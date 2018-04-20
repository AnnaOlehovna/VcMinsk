package com.poddubnaya.vcminsk.presentation.screens.news;


import android.arch.lifecycle.ViewModelProviders;

import com.poddubnaya.vcminsk.R;
import com.poddubnaya.vcminsk.databinding.NewsActivityBinding;
import com.poddubnaya.vcminsk.presentation.base.activity.BaseMvvmActivity;

public class NewsActivity extends BaseMvvmActivity<NewsActivityBinding, NewsActivityViewModel,NewsRouter> {
    @Override
    public int provideLayoutId() {
        return R.layout.news_activity;
    }

    @Override
    public NewsActivityViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(NewsActivityViewModel.class);
    }

    @Override
    public NewsRouter provideRouter() {
        return new NewsRouter(this);
    }
}
