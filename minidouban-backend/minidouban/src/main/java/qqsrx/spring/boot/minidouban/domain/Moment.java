package qqsrx.spring.boot.minidouban.domain;

import java.util.Date;

public class Moment {
    private int momentId;
    private int userId;
    private String momentContent;
    private Date momentPostTime;

    public Moment() {
    }

    public Moment(int userId, String momentContent) {
        this.userId = userId;
        this.momentContent = momentContent;
    }

    public int getUserId() {
        return userId;
    }

    public Date getMomentPostTime() {
        return momentPostTime;
    }

    public int getMomentId() {
        return momentId;
    }

    public String getMomentContent() {
        return momentContent;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setMomentContent(String momentContent) {
        this.momentContent = momentContent;
    }

    public void setMomentId(int momentId) {
        this.momentId = momentId;
    }

    public void setMomentPostTime(Date momentPostTime) {
        this.momentPostTime = momentPostTime;
    }
}
