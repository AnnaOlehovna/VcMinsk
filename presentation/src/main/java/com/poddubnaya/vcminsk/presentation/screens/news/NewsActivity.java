package com.poddubnaya.vcminsk.presentation.screens.news;


import android.arch.lifecycle.ViewModelProviders;

import com.poddubnaya.vcminsk.R;
import com.poddubnaya.vcminsk.databinding.NewsActivityBinding;
import com.poddubnaya.vcminsk.presentation.base.BaseMvvmActivity;

public class NewsActivity extends BaseMvvmActivity<NewsActivityBinding, NewsViewModel,NewsRouter> {
    @Override
    public int provideLayoutId() {
        return R.layout.news_activity;
    }

    @Override
    public NewsViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(NewsViewModel.class);
    }

    @Override
    public NewsRouter provideRouter() {
        return new NewsRouter(this);
    }
}
