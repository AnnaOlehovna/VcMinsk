package com.poddubnaya.vcminsk.presentation.screens.teams.fragment;


import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.poddubnaya.data.constants.Constants;
import com.poddubnaya.vcminsk.R;


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
        if(tabTitles[position].equals(Constants.MINCHANKA)){
            return activity.getResources().getString(R.string.minchanka_team);
        }else return activity.getResources().getString(R.string.stroitel_team);
    }
}
