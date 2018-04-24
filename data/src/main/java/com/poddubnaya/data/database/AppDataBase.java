package com.poddubnaya.data.database;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.poddubnaya.data.database.databaseEntity.MinchankaPlayer;
import com.poddubnaya.data.database.databaseEntity.MinchankaStaff;
import com.poddubnaya.data.database.databaseEntity.StroitelPlayer;
import com.poddubnaya.data.database.databaseEntity.StroitelStaff;
import com.poddubnaya.data.entity.News;

@Database(entities = {MinchankaPlayer.class, MinchankaStaff.class,
        StroitelPlayer.class, StroitelStaff.class, News.class},version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract PlayersDao getPlayersDao();
    public abstract StaffDao getStaffDao();
    public abstract NewsDao getNewsDao();
}
