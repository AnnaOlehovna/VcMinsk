package com.poddubnaya.data.rest;

import com.poddubnaya.data.entity.Player;
import com.poddubnaya.data.entity.Staff;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RestApi {

    @GET
    Flowable<List<Player>> getPlayers(@Url String url);

    @GET
    Flowable<List<Staff>> getStaff(@Url String url);



}
