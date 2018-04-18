package com.poddubnaya.vcminsk.presentation.screens.main;


import android.arch.lifecycle.ViewModelProviders;

import com.poddubnaya.vcminsk.R;
import com.poddubnaya.vcminsk.databinding.MainActivityBinding;
import com.poddubnaya.vcminsk.presentation.base.BaseMvvmActivity;

public class MainActivity extends BaseMvvmActivity<MainActivityBinding, MainViewModel,MainRouter> {
    @Override
    public int provideLayoutId() {
        return R.layout.main_activity;
    }

    @Override
    public MainViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(MainViewModel.class);
    }

    @Override
    public MainRouter provideRouter() {
        return new MainRouter(this);
    }
}
