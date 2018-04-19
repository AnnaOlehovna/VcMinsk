package com.poddubnaya.data.entity;


import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Staff {

    @PrimaryKey
    @SerializedName("surname")
    @Expose
    @NonNull
    private String surname;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("middleName")
    @Expose
    private String middleName;

    @SerializedName("role")
    @Expose
    private String role;

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getRole() {
        return role;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
