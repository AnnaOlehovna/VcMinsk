package com.poddubnaya.domain.entity;


public class StaffDomain implements Comparable<StaffDomain> {
    private int prior;

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

    public StaffDomain(int prior, String surname, String name, String middleName, String role) {
        this.prior = prior;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.role = role;
    }

    @Override
    public int compareTo(StaffDomain o) {
        if(this.prior==o.prior)
            return 0;
        if(this.prior>o.prior) return 1;
        return -1;
    }
}
