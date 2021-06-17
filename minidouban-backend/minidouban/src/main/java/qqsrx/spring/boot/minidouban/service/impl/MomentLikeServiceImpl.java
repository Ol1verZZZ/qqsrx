package qqsrx.spring.boot.minidouban.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qqsrx.spring.boot.minidouban.dao.MomentLikeDao;
import qqsrx.spring.boot.minidouban.domain.MomentLike;
import qqsrx.spring.boot.minidouban.service.MomentLikeService;

@Service
public class MomentLikeServiceImpl implements MomentLikeService {
    @Autowired
    private MomentLikeDao momentLikeDao;

    @Override
    public int add(MomentLike momentLike) {
        return momentLikeDao.add(momentLike);
    }

    @Override
    public int delete(int userId, int momentId) {
        return momentLikeDao.delete(userId, momentId);
    }

    @Override
    public int getMomentLikeSum(int momentId) {
        return momentLikeDao.getMomentLikeSum(momentId);
    }

    @Override
    public boolean hasLiked(int userId, int momentId) {
        return momentLikeDao.hasLiked(userId, momentId);
    }
}
