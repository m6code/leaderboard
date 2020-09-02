package com.m6code.leaderboard.data;

public class LearningData {


    private String name;
    private String hours;
    private String country;
    private String badgeURL;

    public LearningData(String name, String hours, String country, String badgeURL) {
        this.name = name;
        this.hours = hours;
        this.country = country;
        this.badgeURL = badgeURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadgeURL() {
        return badgeURL;
    }

    public void setBadgeURL(String badgeURL) {
        this.badgeURL = badgeURL;
    }
}
