package com.poddubnaya.data.database;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.poddubnaya.data.database.databaseEntity.MinchankaPlayer;
import com.poddubnaya.data.database.databaseEntity.MinchankaStaff;
import com.poddubnaya.data.database.databaseEntity.StroitelStaff;
import com.poddubnaya.data.entity.Player;
import com.poddubnaya.data.entity.Staff;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface StaffDao {

    @Insert
    void insertMinchanka(List<MinchankaStaff> pList);

    @Query("SELECT * FROM MinchankaStaff")
    Flowable<List<MinchankaStaff>> getMinchankaStaff();


    @Query("DELETE FROM MinchankaStaff")
    void deleteMinchankaStaff();

    @Insert
    void insertStroitel(List<StroitelStaff> pList);

    @Query("SELECT * FROM StroitelStaff")
    Flowable<List<StroitelStaff>> getStroitelStaff();


    @Query("DELETE FROM StroitelStaff")
    void deleteStroitelStaff();
}
