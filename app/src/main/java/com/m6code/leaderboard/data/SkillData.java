package com.m6code.leaderboard.data;

public class SkillData {
    private String name;
    private String score;
    private String country;
    private String badgeURL;

    public SkillData(String name, String score, String country, String badgeURL) {
        this.name = name;
        this.score = score;
        this.country = country;
        this.badgeURL = badgeURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
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
