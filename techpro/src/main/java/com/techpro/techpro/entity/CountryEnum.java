package com.techpro.techpro.entity;

public enum CountryEnum {

    ROMANIA("Romania"),
    FRANCE("France"),
    BULGARIA("Bulgaria"),
    SERBIA("Serbia")
    ;

    private final String country;

    CountryEnum(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
}
