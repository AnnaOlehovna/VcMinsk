package com.poddubnaya.data.database.databaseEntity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.poddubnaya.data.entity.Staff;

@Entity(tableName = "MinchankaStaff")
public class MinchankaStaff extends Staff {

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
    public MinchankaStaff(String surname, String name, String middleName, String role, int prior, @NonNull String id) {
        super(surname, name, middleName, role, prior);
        this.id = id;
    }

    @Ignore
    public MinchankaStaff(String surname, String name, String middleName, String role, int prior) {
        super(surname, name, middleName, role, prior);
    }

    public MinchankaStaff() {
    }
}
