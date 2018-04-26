package com.poddubnaya.vcminsk.presentation.base.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.poddubnaya.data.utils.InternetConnection;
import com.poddubnaya.vcminsk.BR;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;


public abstract class BaseMvvmActivity<Binding extends ViewDataBinding,
        ViewModel extends BaseActivityViewModel, R extends Router>  extends AppCompatActivity{

    protected Binding binding;
    protected ViewModel viewModel;
    private Disposable disposable;


    @Nullable
    protected R router;


    public abstract int provideLayoutId();
    public abstract ViewModel provideViewModel();
    public abstract R provideRouter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = provideViewModel();
        binding = DataBindingUtil.setContentView(this, provideLayoutId());
        binding.setVariable(BR.viewModel,viewModel);
        binding.executePendingBindings();
        router = provideRouter();
        viewModel.attachRouter(router);
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.onResume();
        disposable= checkInternet()
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean)
                            viewModel.onResume();
                    }
                });

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (disposable != null)
            disposable.dispose();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        router =null;
        viewModel.detachRouter();
    }



    private Observable<Boolean> checkInternet() {
        return Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(final ObservableEmitter<Boolean> emitter) throws Exception {
                BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
                    @Override
                    public void onReceive(Context context, Intent intent) {
                        boolean isConnected = InternetConnection.getInstance().checkNetwork(context);
                        emitter.onNext(isConnected);
                    }
                };
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
                registerReceiver(broadcastReceiver, intentFilter);
            }
        });
    }

}