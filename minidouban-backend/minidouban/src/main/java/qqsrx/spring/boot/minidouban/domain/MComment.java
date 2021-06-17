package qqsrx.spring.boot.minidouban.domain;

import java.util.Date;

public class MComment {
    private int commentId;
    private int momentId;
    private int userId;
    private int toUserId;
    private String commentContent;
    private Date commentTime;

    public MComment() {
    }

    public MComment(int momentId, int userId, int toUserId, String commentContent) {
        this.momentId = momentId;
        this.userId = userId;
        this.toUserId = toUserId;
        this.commentContent = commentContent;
    }

    public int getUserId() {
        return userId;
    }

    public int getMomentId() {
        return momentId;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public int getCommentId() {
        return commentId;
    }

    public int getToUserId() {
        return toUserId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setMomentId(int momentId) {
        this.momentId = momentId;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public void setToUserId(int toUserId) {
        this.toUserId = toUserId;
    }
}
