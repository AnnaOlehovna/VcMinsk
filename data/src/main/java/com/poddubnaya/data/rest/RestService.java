package com.poddubnaya.data.rest;


import com.poddubnaya.data.constants.Constants;
import com.poddubnaya.data.entity.ErrorType;
import com.poddubnaya.data.entity.MyError;
import com.poddubnaya.data.entity.News;
import com.poddubnaya.data.entity.Player;
import com.poddubnaya.data.entity.Staff;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

@Singleton
public class RestService {

    private RestApi restApi;
    private ErrorTransformers errorTransformers;

    @Inject

    public RestService(RestApi restApi, ErrorTransformers errorTransformers) {
        this.restApi = restApi;
        this.errorTransformers = errorTransformers;
    }


    public Flowable<List<Player>> getPlayers(String team, String offset) {
        String url = null;
        if (team.equals(Constants.MINCHANKA)) {
            url = Constants.MINCHANKA_PLAYERS_URL;
        } else if (team.equals(Constants.STROITEL)) {
            url = Constants.STROITEL_PLAYERS_URL;
        }
        return restApi.getPlayers(url, offset);
    }

    public Flowable<List<Staff>> getStaff(String team) {
        String url = null;
        if (team.equals(Constants.MINCHANKA)) {
            url = Constants.MINCHANKA_STAFF_URL;
        } else if (team.equals(Constants.STROITEL)) {
            url = Constants.STROITEL_STAFF_URL;
        }
        return restApi.getStaff(url);
    }

    public Flowable<List<News>> getNews(String[] team) {
        String str;
        if (team.length == 0) {
            List<News> news = new ArrayList<>();
            return Flowable.error(new MyError(ErrorType.NO_TEAM));
        } else if (team.length == 1) {
            str = "team='" + team[0] + "'";
        } else {
            String temp = "'" + team[0] + "'";
            for (int i = 1; i < team.length; i++) {
                temp = temp.concat(",'" + team[i] + "'");
            }
            str = "team in" + "(" + temp + ")";
        }
        return restApi
                .getNews(str)
                .compose(errorTransformers.<List<News>,MyError>parseHttpError());
    }

    public Flowable<News> getNewsById(String id){
        return restApi
                .getNewsById(id);
//                .compose(errorTransformers.<News,MyError>parseHttpError());
    }

}
