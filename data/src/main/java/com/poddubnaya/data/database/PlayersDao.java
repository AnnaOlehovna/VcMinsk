package com.poddubnaya.data.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.poddubnaya.data.database.databaseEntity.MinchankaPlayer;
import com.poddubnaya.data.entity.Player;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface PlayersDao {

    @Insert
    void insertMinchanka(List<MinchankaPlayer> pList);

    @Query("SELECT * FROM MinchankaPlayer")
    Flowable<List<MinchankaPlayer>> getMinchankaPlayers();
}
