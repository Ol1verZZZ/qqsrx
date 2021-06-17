package qqsrx.spring.boot.minidouban.dao;

import qqsrx.spring.boot.minidouban.domain.ShortReview;

import java.util.List;

public interface ShortReviewDao {
    public List<ShortReview> getSRListByIMDbId(String imdbId);
    public int add(ShortReview sr);
    public int update(String imdbId, int userId, ShortReview sr);
    public int delete(String imdbId, int userId);
    public boolean hasWatched(String imdbId, int userId);
    public List<ShortReview> getSRListByUserId(int userId);
}
