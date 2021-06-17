package qqsrx.spring.boot.minidouban.dao;

import qqsrx.spring.boot.minidouban.domain.MomentLike;

public interface MomentLikeDao {
    public int add(MomentLike momentLike);
    public int delete(int userId, int momentId);
    public int getMomentLikeSum(int momentId);
    public boolean hasLiked(int userId, int momentId);
}
