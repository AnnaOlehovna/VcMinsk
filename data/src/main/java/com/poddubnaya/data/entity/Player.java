package com.poddubnaya.data.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Player {

    @SerializedName("objectId")
    @Expose
    private String objectId;

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

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public Player(int playerNumber, String surname, String name, String role, int year, int height, String nationality) {
        this.playerNumber = playerNumber;
        this.surname = surname;
        this.name = name;
        this.role = role;
        this.year = year;
        this.height = height;
        this.nationality = nationality;
    }

    public Player() {
    }

}
