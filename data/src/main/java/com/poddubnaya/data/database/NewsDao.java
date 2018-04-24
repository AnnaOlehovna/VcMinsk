package com.poddubnaya.data.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;


import com.poddubnaya.data.entity.News;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface NewsDao {


    @Insert
    void insertNews(List<News> nList);

    @Query("SELECT * FROM News WHERE team IN(:teams)")
    Flowable<List<News>> getByTeams(String[] teams);

    @Query("SELECT * FROM News WHERE objectId = :id LIMIT 1")
    Flowable<List<News>> getById(String id);

    @Query("DELETE FROM News")
    void deleteNews();
}
