package com.poddubnaya.vcminsk.injection;

import com.poddubnaya.vcminsk.presentation.screens.news.NewsActivity;
import com.poddubnaya.vcminsk.presentation.screens.news.NewsViewModel;
import com.poddubnaya.vcminsk.presentation.screens.singleNews.SingleNewsViewModel;
import com.poddubnaya.vcminsk.presentation.screens.teams.fragment.TeamViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(TeamViewModel teamViewModel);
    void inject(NewsViewModel newsViewModel);
    void inject(SingleNewsViewModel singleNewsViewModel);
    void inject(NewsActivity newsActivity);

}
