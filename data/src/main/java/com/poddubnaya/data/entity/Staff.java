package com.poddubnaya.data.entity;


import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Staff {

    @SerializedName("objectId")
    @Expose
    private String objectId;

    @SerializedName("surname")
    @Expose
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

    @SerializedName("prior")
    @Expose
    private int prior;

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

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public int getPrior() {
        return prior;
    }

    public void setPrior(int prior) {
        this.prior = prior;
    }

    public Staff(String surname, String name, String middleName, String role, int prior) {
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.role = role;
        this.prior = prior;
    }

    public Staff() {
    }


}
