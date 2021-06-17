package qqsrx.spring.boot.minidouban.service;

import qqsrx.spring.boot.minidouban.domain.SRLike;

public interface SRLikeService {
    public int add(SRLike srLike);
    public int delete(String imdbId, int ownerId, int userId);
    public int getSRLikeSum(String imdbId, int ownerId);
    public boolean hasLiked(String imdbId, int ownerId, int userId);
}
