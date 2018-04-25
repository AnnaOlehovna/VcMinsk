package com.poddubnaya.vcminsk.presentation.screens.news;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.poddubnaya.data.constants.Constants;
import com.poddubnaya.data.constants.MySharedPref;
import com.poddubnaya.vcminsk.R;
import com.poddubnaya.vcminsk.app.App;
import com.poddubnaya.vcminsk.databinding.NewsActivityBinding;
import com.poddubnaya.vcminsk.presentation.base.activity.BaseMvvmActivity;

import javax.inject.Inject;

public class NewsActivity extends BaseMvvmActivity<NewsActivityBinding, NewsViewModel, NewsRouter> {

    @Inject
    public MySharedPref mySharedPref;

    private boolean minchankaOn = false;
    private boolean stroitelOn = false;

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
        App.getAppComponent().inject(this);
        Toolbar toolbar = binding.toolBar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.arrow_back_black_24dp);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.news_menu, menu);
        String[] array = mySharedPref.getSharedPref();
        if (array.length == 2) {
            minchankaOn = true;
            stroitelOn = true;
        } else if (array.length == 1) {
            if (array[0].equals(Constants.MINCHANKA)) {
                minchankaOn = true;
            } else stroitelOn = true;
        }

        MenuItem minchankaItem = menu.findItem(R.id.minchaka_chooser);
        minchankaItem.setChecked(minchankaOn);

        MenuItem stroitelItem = menu.findItem(R.id.stroitel_chooser);
        stroitelItem.setChecked(stroitelOn);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.minchaka_chooser:
                if (item.isChecked()) {
                    item.setChecked(false);
                    minchankaOn = false;
                } else {
                    item.setChecked(true);
                    minchankaOn = true;
                }
                break;
            case R.id.stroitel_chooser:
                if (item.isChecked()) {
                    item.setChecked(false);
                    stroitelOn = false;
                } else {
                    item.setChecked(true);
                    stroitelOn = true;
                }
                break;
            default:
                break;
        }
        mySharedPref.saveSharedPref(minchankaOn, stroitelOn);
        viewModel.onResume();
        return super.onOptionsItemSelected(item);
    }
}
