package com.techpro.techpro.entity;

public enum LeagueEnum {

    FIRST_LEAGUE("First League"),
    SECOND_LEAGUE("Second League"),
    THIRD_LEAGUE("Third League")
    ;

    private final String league;

    LeagueEnum(String league) {
        this.league = league;
    }

    public String getLeague() {
        return league;
    }
}
