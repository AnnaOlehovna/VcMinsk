package com.poddubnaya.vcminsk.presentation.screens.news;


import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.widget.Toast;

import com.poddubnaya.data.constants.Constants;
import com.poddubnaya.data.constants.MySharedPref;
import com.poddubnaya.data.entity.MyError;
import com.poddubnaya.domain.entity.NewsDomain;
import com.poddubnaya.domain.usecases.GetNewsUseCase;
import com.poddubnaya.vcminsk.R;
import com.poddubnaya.vcminsk.app.App;
import com.poddubnaya.vcminsk.presentation.base.activity.BaseActivityViewModel;
import com.poddubnaya.vcminsk.presentation.screens.news.recycler.NewsRecyclerAdapter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

public class NewsViewModel extends BaseActivityViewModel<NewsRouter> {

    public NewsRecyclerAdapter adapter = new NewsRecyclerAdapter();

    public ObservableBoolean isEmpty = new ObservableBoolean();
    public ObservableField<String> text = new ObservableField<>();

    public String[] teams;
    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    @Inject
    public GetNewsUseCase getNewsUseCase;

    @Inject
    public MySharedPref mySharedPref;

    public NewsViewModel() {
        adapter
                .observeClick()
                .subscribe(new Consumer<NewsDomain>() {
                    @Override
                    public void accept(NewsDomain newsDomain) throws Exception {
                        if(router!=null){
                            router.navigateToSingleNews(newsDomain.getObjectId());
                        }
                    }
                });
    }

    @Override
    public void onResume() {
        super.onResume();
        teams = mySharedPref.getSharedPref();
        getNewsUseCase
                .getNews(teams)
                .isEmpty()
                .subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                isEmpty.set(aBoolean);
            }
        });

        getNewsUseCase
                .getNews(teams)
                .subscribe(new Consumer<List<NewsDomain>>() {
                    @Override
                    public void accept(List<NewsDomain> newsDomains) throws Exception {
                        adapter.setItemList(newsDomains);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (router != null) {
                            if (throwable instanceof MyError) {
                                MyError myError = (MyError) throwable;
                                switch (myError.getMyError()) {
                                    case NO_INTERNET:
                                        text.set(router.getActivity().getString(R.string.no_internet));
                                        break;
                                    case SERVER_NOT_AVAILABLE:
                                        Toast.makeText(router.getActivity(), "Sorry, smth wrong with server. Please, try later" +
                                                "Please, check internet", Toast.LENGTH_SHORT).show();
                                        break;
                                    case UNKNOWN:
                                        break;
                                }
                            }
                        }
                    }
                });
    }
}
