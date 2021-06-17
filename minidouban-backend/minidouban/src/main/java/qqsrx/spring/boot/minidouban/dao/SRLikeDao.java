package qqsrx.spring.boot.minidouban.dao;

import qqsrx.spring.boot.minidouban.domain.SRLike;

public interface SRLikeDao {
    public int add(SRLike srLike);
    public int delete(String imdbId, int ownerId, int userId);
    public int getSRLikeSum(String imdbId, int ownerId);
    public boolean hasLiked(String imdbId, int ownerId, int userId);
}
