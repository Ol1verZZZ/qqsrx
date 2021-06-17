package qqsrx.spring.boot.minidouban.domain;

public class MomentLike {
    private int userId;
    private int momentId;

    public MomentLike() {
    }

    public MomentLike(int userId, int momentId) {
        this.userId = userId;
        this.momentId = momentId;
    }

    public int getMomentId() {
        return momentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setMomentId(int momentId) {
        this.momentId = momentId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
