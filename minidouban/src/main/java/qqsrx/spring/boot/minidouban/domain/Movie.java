package qqsrx.spring.boot.minidouban.domain;

import java.util.Date;

public class Movie {
    private String imdbId;
    private String chineseName;
    private String englishName;
    private float rate;
    private int creatorId;
    private String typeName;
    private String movieTitle;
    private String country;
    private String language;
    private String releaseDate;
    private String duration;   // minutes
    private String rewards;
    private String movieIntroduction;
    private Date entryCreatTime;
    private Date lastModifiedTime;

    public Movie() {
    }

    public String getEnglishName() {
        return englishName;
    }

    public String getChineseName() {
        return chineseName;
    }

    public float getRate() {
        return rate;
    }

    public Date getEntryCreatTime() {
        return entryCreatTime;
    }

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public String getDuration() {
        return duration;
    }

    public String getCountry() {
        return country;
    }

    public String getIMDbId() {
        return imdbId;
    }

    public String getLanguage() {
        return language;
    }

    public String getMovieIntroduction() {
        return movieIntroduction;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getRewards() {
        return rewards;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setIMDbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public void setEntryCreatTime(Date entryCreatTime) {
        this.entryCreatTime = entryCreatTime;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public void setMovieIntroduction(String movieIntroduction) {
        this.movieIntroduction = movieIntroduction;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setRewards(String rewards) {
        this.rewards = rewards;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
