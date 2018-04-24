package com.poddubnaya.vcminsk.presentation.screens.news;

import android.app.Activity;
import android.content.Intent;

import com.poddubnaya.data.constants.Constants;
import com.poddubnaya.vcminsk.presentation.base.activity.Router;
import com.poddubnaya.vcminsk.presentation.screens.singleNews.SingleNewsActivity;

public class NewsRouter extends Router{

    public NewsRouter(Activity activity) {
        super(activity);
    }

    public void navigateToSingleNews(String id){
        Intent intent = new Intent(getActivity(), SingleNewsActivity.class);
        intent.putExtra(Constants.NEWS_ID, id);
        getActivity().startActivity(intent);

    }
}
