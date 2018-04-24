package com.poddubnaya.vcminsk.presentation.screens.news;


import com.poddubnaya.data.constants.Constants;
import com.poddubnaya.domain.entity.NewsDomain;
import com.poddubnaya.domain.usecases.GetNewsUseCase;
import com.poddubnaya.vcminsk.app.App;
import com.poddubnaya.vcminsk.presentation.base.activity.BaseActivityViewModel;
import com.poddubnaya.vcminsk.presentation.screens.news.recycler.NewsRecyclerAdapter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

public class NewsViewModel extends BaseActivityViewModel<NewsRouter> {

    public NewsRecyclerAdapter adapter = new NewsRecyclerAdapter();

    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    @Inject
    public GetNewsUseCase getNewsUseCase;

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
        getNewsUseCase.getNews(new String[]{Constants.MINCHANKA, Constants.STROITEL})
                .subscribe(new Consumer<List<NewsDomain>>() {
                    @Override
                    public void accept(List<NewsDomain> newsDomains) throws Exception {
                        adapter.setItemList(newsDomains);
                    }
                });
    }
}
