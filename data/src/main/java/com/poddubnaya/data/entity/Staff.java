package com.poddubnaya.data.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Staff {

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
}
