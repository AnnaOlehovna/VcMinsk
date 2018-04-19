package com.poddubnaya.vcminsk.presentation.screens.main;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.poddubnaya.vcminsk.R;
import com.poddubnaya.vcminsk.presentation.base.Router;
import com.poddubnaya.vcminsk.presentation.screens.news.NewsActivity;
import com.poddubnaya.vcminsk.presentation.screens.teams.TeamsActivity;

public class MainRouter extends Router {

    public MainRouter(Activity activity) {
        super(activity);
    }

    public void navigateToTeamsActivity(){
        Intent intent = new Intent(getActivity(), TeamsActivity.class);
        getActivity().startActivity(intent);
    }

    public void registerFanCard(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getActivity().getResources().getString(R.string.fancard_uri)));
        getActivity().startActivity(intent);
    }

    public void navigateToNewsActivity(){
        Intent intent = new Intent(getActivity(), NewsActivity.class);
        getActivity().startActivity(intent);
    }
}
