package qqsrx.spring.boot.minidouban.domain;

public class Friendship {
    private int fromId;
    private int toId;

    public Friendship() {
    }

    public Friendship(int fromId, int toId) {
        this.fromId = fromId;
        this.toId = toId;
    }

    public int getFromId() {
        return fromId;
    }

    public int getToId() {
        return toId;
    }

    public void setFromId(int fromId) {
        this.fromId = fromId;
    }

    public void setToId(int toId) {
        this.toId = toId;
    }
}
