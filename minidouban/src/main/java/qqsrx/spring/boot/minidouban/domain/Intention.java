package qqsrx.spring.boot.minidouban.domain;

import java.util.Date;

public class Intention {
    private int userId;
    private String imdbId;
    private Date markTime;
    private String markDescription;

    public Intention(int userId, String imdbId, String markDescription) {
        this.userId = userId;
        this.imdbId = imdbId;
        this.markDescription = markDescription;
    }

    public Intention(){
    }

    public int getUserId() {
        return userId;
    }

    public Date getMarkTime() {
        return markTime;
    }

    public String getImdbId() {
        return imdbId;
    }

    public String getMarkDescription() {
        return markDescription;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public void setMarkDescription(String markDescription) {
        this.markDescription = markDescription;
    }

    public void setMarkTime(Date markTime) {
        this.markTime = markTime;
    }
}
