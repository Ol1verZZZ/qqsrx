package qqsrx.spring.boot.minidouban.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qqsrx.spring.boot.minidouban.dao.MomentDao;
import qqsrx.spring.boot.minidouban.domain.Moment;
import qqsrx.spring.boot.minidouban.service.MomentService;

import java.util.List;

@Service
public class MomentServiceImpl implements MomentService {
    @Autowired
    private MomentDao momentDao;

    @Override
    public int add(Moment moment) {
        return momentDao.add(moment);
    }

    @Override
    public List<Moment> getAllMoments() {
        return momentDao.getAllMoments();
    }

    @Override
    public List<Moment>  getMomentListByUserId(int userId) {
        return momentDao.getMomentListByUserId(userId);
    }
}
