package com.poddubnaya.data.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Player {

    @SerializedName("number")
    @Expose
    private int playerNumber;

    @SerializedName("surname")
    @Expose
    private String surname;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("role")
    @Expose
    private String role;

    @SerializedName("year")
    @Expose
    private int year;

    @SerializedName("height")
    @Expose
    private int height;

    @SerializedName("nationality")
    @Expose
    private String nationality;

    public int getPlayerNumber() {
        return playerNumber;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public int getYear() {
        return year;
    }

    public int getHeight() {
        return height;
    }

    public String getNationality() {
        return nationality;
    }
}
