package com.poddubnaya.data.rest;

import com.poddubnaya.data.entity.News;
import com.poddubnaya.data.entity.Player;
import com.poddubnaya.data.entity.Staff;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface RestApi {

    @GET
    Flowable<List<Player>> getPlayers(@Url String url, @Query("offset") String offset);

    @GET
    Flowable<List<Staff>> getStaff(@Url String url);

    @GET("data/news")
    Flowable<List<News>> getNews(@Query("where") String team);

}
