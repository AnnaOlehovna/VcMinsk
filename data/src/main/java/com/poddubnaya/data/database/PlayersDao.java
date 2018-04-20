package com.poddubnaya.data.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.poddubnaya.data.database.databaseEntity.MinchankaPlayer;
import com.poddubnaya.data.database.databaseEntity.StroitelPlayer;
import com.poddubnaya.data.entity.Player;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface PlayersDao {

    @Insert
    void insertMinchanka(List<MinchankaPlayer> pList);

    @Query("SELECT * FROM MinchankaPlayer")
    Flowable<List<MinchankaPlayer>> getMinchankaPlayers();

    @Query("DELETE FROM MinchankaPlayer")
    void deleteMinchankaPlayer();


    @Insert
    void insertStroitel(List<StroitelPlayer> pList);

    @Query("SELECT * FROM StroitelPlayer")
    Flowable<List<StroitelPlayer>> getStroitelPlayers();

    @Query("DELETE FROM StroitelPlayer")
    void deleteStroitelPlayer();

}
