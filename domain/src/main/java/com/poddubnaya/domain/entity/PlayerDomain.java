package com.poddubnaya.domain.entity;

public class PlayerDomain implements Comparable<PlayerDomain>{

    private int playerNumber;

    private String surname;

    private String name;

    private String role;

    private int year;

    private int height;

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

    public PlayerDomain(int playerNumber, String surname, String name, String role, int year, int height, String nationality) {
        this.playerNumber = playerNumber;
        this.surname = surname;
        this.name = name;
        this.role = role;
        this.year = year;
        this.height = height;
        this.nationality = nationality;
    }

    @Override
    public int compareTo(PlayerDomain o) {
        if(this.playerNumber==o.playerNumber)
            return 0;
        if(this.playerNumber>o.playerNumber) return 1;
        return -1;
    }
}
