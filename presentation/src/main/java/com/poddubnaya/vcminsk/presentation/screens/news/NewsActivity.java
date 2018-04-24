package com.poddubnaya.vcminsk.presentation.screens.news;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.poddubnaya.vcminsk.R;
import com.poddubnaya.vcminsk.databinding.NewsActivityBinding;
import com.poddubnaya.vcminsk.presentation.base.activity.BaseMvvmActivity;

public class NewsActivity extends BaseMvvmActivity<NewsActivityBinding, NewsViewModel, NewsRouter> {
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = binding.toolBar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        binding.toolbatTitle.setText(getResources().getString(R.string.news_button));
        binding.newsRecycler.setLayoutManager(new LinearLayoutManager(this));
        binding.newsRecycler.setHasFixedSize(true);
        binding.newsRecycler.setAdapter(viewModel.adapter);
    }
}
