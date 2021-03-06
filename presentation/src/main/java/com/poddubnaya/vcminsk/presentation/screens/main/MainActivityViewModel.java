package com.poddubnaya.vcminsk.presentation.screens.main;

import android.view.View;

import com.poddubnaya.vcminsk.presentation.base.activity.BaseActivityViewModel;

public class MainActivityViewModel extends BaseActivityViewModel<MainRouter> {

    @Override
    public void createInject() {

    }

    public void onTeamsButtonClick(View view){
        if(router!=null)
            router.navigateToTeamsActivity();
    }

    public void onCardButtonClick(View view){
        if (router!=null)
            router.registerFanCard();

    }

    public void onNewsButtonClick(View view){
        if(router!=null)
            router.navigateToNewsActivity();
    }

}
