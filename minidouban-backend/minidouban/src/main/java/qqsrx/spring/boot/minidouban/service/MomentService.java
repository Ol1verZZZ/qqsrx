package qqsrx.spring.boot.minidouban.service;

import qqsrx.spring.boot.minidouban.domain.Moment;

import java.util.List;

public interface MomentService {
    public int add(Moment moment);
    public List<Moment> getAllMoments();
    public List<Moment> getMomentListByUserId(int userId);
}
