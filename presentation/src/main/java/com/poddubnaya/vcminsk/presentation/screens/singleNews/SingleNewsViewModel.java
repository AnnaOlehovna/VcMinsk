package com.poddubnaya.vcminsk.presentation.screens.singleNews;

import android.databinding.ObservableField;
import android.widget.Toast;

import com.poddubnaya.data.entity.MyError;
import com.poddubnaya.domain.entity.NewsDomain;
import com.poddubnaya.domain.usecases.GetNewsByIdUseCase;
import com.poddubnaya.vcminsk.R;
import com.poddubnaya.vcminsk.app.App;
import com.poddubnaya.vcminsk.presentation.base.activity.BaseActivityViewModel;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;


public class SingleNewsViewModel extends BaseActivityViewModel<SingleNewsRouter> {

    public String id ="";

    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> text = new ObservableField<>();

    @Inject
   public GetNewsByIdUseCase getNewsByIdUseCase;

    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        getNewsByIdUseCase.getNewsById(id)
                .subscribe(new Consumer<NewsDomain>() {
                    @Override
                    public void accept(NewsDomain newsDomain) throws Exception {
                        title.set(newsDomain.getTitle());
                        text.set(newsDomain.getText());
                    }
                });
    }
}
