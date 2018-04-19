package com.poddubnaya.vcminsk.presentation.screens.teams;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.poddubnaya.vcminsk.R;
import com.poddubnaya.vcminsk.databinding.TeamsActivityBinding;
import com.poddubnaya.vcminsk.presentation.base.BaseMvvmActivity;

public class TeamsActivity extends BaseMvvmActivity<TeamsActivityBinding, TeamsViewModel,TeamsRouter> {
    @Override
    public int provideLayoutId() {
        return R.layout.teams_activity;
    }

    @Override
    public TeamsViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(TeamsViewModel.class);
    }

    @Override
    public TeamsRouter provideRouter() {
        return new TeamsRouter(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Teams".toUpperCase());
       ViewPager viewPager = binding.viewPager;
       viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(),this));
        TabLayout tablayout = binding.tablayout;
        tablayout.setupWithViewPager(viewPager);
    }
}
