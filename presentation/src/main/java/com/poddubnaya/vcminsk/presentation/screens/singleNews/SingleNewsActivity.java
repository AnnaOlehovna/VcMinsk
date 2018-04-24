package com.poddubnaya.vcminsk.presentation.screens.singleNews;

import android.arch.lifecycle.ViewModelProviders;


import com.poddubnaya.vcminsk.R;
import com.poddubnaya.vcminsk.databinding.SingleNewsActivityBinding;
import com.poddubnaya.vcminsk.presentation.base.activity.BaseMvvmActivity;


public class SingleNewsActivity extends BaseMvvmActivity<SingleNewsActivityBinding, SingleNewsViewModel,SingleNewsRouter> {

    @Override
    public int provideLayoutId() {
        return R.layout.single_news_activity;
    }

    @Override
    public SingleNewsViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(SingleNewsViewModel.class);
    }

    @Override
    public SingleNewsRouter provideRouter() {
        return new SingleNewsRouter(this);
    }
}
