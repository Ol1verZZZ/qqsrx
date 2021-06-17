package qqsrx.spring.boot.minidouban.domain;

public class SRLike {
    private int ownerId;
    private int userId;
    private String imdbId;

    public SRLike() {
    }

    public SRLike(int ownerId, String imdbId, int userId) {
        this.ownerId = ownerId;
        this.imdbId = imdbId;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public String getImdbId() {
        return imdbId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}
