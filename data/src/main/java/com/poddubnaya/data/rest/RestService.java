package com.poddubnaya.data.rest;


import com.poddubnaya.data.constants.Constants;
import com.poddubnaya.data.entity.Player;
import com.poddubnaya.data.entity.Staff;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

@Singleton
public class RestService {

    private RestApi restApi;

    @Inject

    public RestService(RestApi restApi) {
        this.restApi = restApi;
    }


    public Flowable<List<Player>> getPlayers(String team, String offset) {
        String url = null;
        if (team.equals(Constants.MINCHANKA))
        {
            url = Constants.MINCHANKA_PLAYERS_URL;
        }else if (team.equals(Constants.STROITEL)) {
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
}
