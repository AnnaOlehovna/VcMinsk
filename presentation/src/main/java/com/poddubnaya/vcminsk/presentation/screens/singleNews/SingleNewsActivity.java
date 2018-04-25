package com.poddubnaya.vcminsk.presentation.screens.singleNews;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.poddubnaya.data.constants.Constants;
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
        String newsId = getIntent().getStringExtra(Constants.NEWS_ID);
        SingleNewsViewModel viewModel
                =  ViewModelProviders.of(this).get(SingleNewsViewModel.class);
        viewModel.id = newsId;
        return viewModel;
    }

    @Override
    public SingleNewsRouter provideRouter() {
        return new SingleNewsRouter(this);
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
    }
}
