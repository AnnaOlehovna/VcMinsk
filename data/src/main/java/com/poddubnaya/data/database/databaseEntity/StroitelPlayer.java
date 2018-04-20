package com.poddubnaya.data.database.databaseEntity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.poddubnaya.data.entity.Player;

@Entity(tableName = "StroitelPlayer")
public class StroitelPlayer extends Player {

    @PrimaryKey
    @NonNull
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Ignore
    public StroitelPlayer(int playerNumber, String surname, String name, String role, int year, int height, String nationality) {
        super(playerNumber, surname, name, role, year, height, nationality);
    }

    @Ignore
    public StroitelPlayer(int playerNumber, String surname, String name, String role, int year, int height, String nationality, String id) {
        super(playerNumber, surname, name, role, year, height, nationality);
        this.id = id;
    }

    public StroitelPlayer() {
    }

}
