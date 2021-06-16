package qqsrx.spring.boot.minidouban.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qqsrx.spring.boot.minidouban.dao.ShortReviewDao;
import qqsrx.spring.boot.minidouban.domain.ShortReview;
import qqsrx.spring.boot.minidouban.service.ShortReviewService;

import java.util.List;

@Service
public class ShortReviewServiceImpl implements ShortReviewService {
    @Autowired
    private ShortReviewDao srDao;

    @Override
    public List<ShortReview> getSRListByIMDbId(String imdbId) {
        return srDao.getSRListByIMDbId(imdbId);
    }

    @Override
    public int add(ShortReview sr) {
        return srDao.add(sr);
    }

    @Override
    public int update(String imdbId, int userId, ShortReview sr) {
        return srDao.update(imdbId, userId, sr);
    }

    @Override
    public int delete(String imdbId, int userId) {
        return srDao.delete(imdbId, userId);
    }

    @Override
    public boolean hasWatched(String imdbId, int userId) {
        return srDao.hasWatched(imdbId, userId);
    }

    @Override
    public List<ShortReview> getSRListByUserId(int userId) {
        return srDao.getSRListByUserId(userId);
    }
}
