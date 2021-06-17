package qqsrx.spring.boot.minidouban.service;

import qqsrx.spring.boot.minidouban.domain.MomentLike;

public interface MomentLikeService {
    public int add(MomentLike momentLike);
    public int delete(int userId, int momentId);
    public int getMomentLikeSum(int momentId);
    public boolean hasLiked(int userId, int momentId);
}
