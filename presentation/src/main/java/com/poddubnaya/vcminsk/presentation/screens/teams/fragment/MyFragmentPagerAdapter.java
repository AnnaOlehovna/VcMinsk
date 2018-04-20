package com.poddubnaya.vcminsk.presentation.screens.teams.fragment;


import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.poddubnaya.data.constants.Constants;


public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[] {Constants.MINCHANKA, Constants.STROITEL };
    private Activity activity;

    public MyFragmentPagerAdapter(FragmentManager fm, Activity activity) {
        super(fm);
        this.activity = activity;
    }

    @Override
    public Fragment getItem(int position) {
        TeamFragment teamFragment = TeamFragment.newInstance(tabTitles[position]);
        teamFragment.setActivity(activity);
        return teamFragment;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
