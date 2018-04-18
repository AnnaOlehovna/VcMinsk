package com.poddubnaya.domain.entity;


public class StaffDomain {

   private String surname;

    private String name;

    private String middleName;


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


    public StaffDomain(String surname, String name, String middleName, String role) {
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.role = role;
    }
}
