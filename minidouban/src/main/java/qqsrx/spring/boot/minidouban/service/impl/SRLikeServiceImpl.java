package qqsrx.spring.boot.minidouban.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qqsrx.spring.boot.minidouban.dao.SRLikeDao;
import qqsrx.spring.boot.minidouban.domain.SRLike;
import qqsrx.spring.boot.minidouban.service.SRLikeService;

@Service
public class SRLikeServiceImpl implements SRLikeService {
    @Autowired
    private SRLikeDao srLikeDao;

    @Override
    public int add(SRLike srLike) {
        return srLikeDao.add(srLike);
    }

    @Override
    public int delete(String imdbId, int ownerId, int userId) {
        return srLikeDao.delete(imdbId, ownerId, userId);
    }

    @Override
    public int getSRLikeSum(String imdbId, int ownerId) {
        return srLikeDao.getSRLikeSum(imdbId, ownerId);
    }

    @Override
    public boolean hasLiked(String imdbId, int ownerId, int userId) {
        return srLikeDao.hasLiked(imdbId, ownerId, userId);
    }
}
