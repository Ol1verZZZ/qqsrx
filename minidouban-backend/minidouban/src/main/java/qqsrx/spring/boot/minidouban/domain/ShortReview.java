package qqsrx.spring.boot.minidouban.domain;

import java.util.Date;

public class ShortReview {
    private String imdbId;
    private int userId;
    private int rate;
    private String srContent;
    private Date srPostTime;

    public ShortReview(){
    }

    public ShortReview(String imdbId, int userId, int rate, String srContent) {
        this.imdbId = imdbId;
        this.userId = userId;
        this.rate = rate;
        this.srContent = srContent;
    }

    public String getImdbId() {
        return imdbId;
    }

    public int getUserId() {
        return userId;
    }

    public Date getSrPostTime() {
        return srPostTime;
    }

    public int getRate() {
        return rate;
    }

    public String getSrContent() {
        return srContent;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setSrContent(String srContent) {
        this.srContent = srContent;
    }

    public void setSrPostTime(Date srPostTime) {
        this.srPostTime = srPostTime;
    }
}

