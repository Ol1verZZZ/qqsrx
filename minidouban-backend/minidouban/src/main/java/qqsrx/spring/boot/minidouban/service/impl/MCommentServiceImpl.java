package qqsrx.spring.boot.minidouban.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qqsrx.spring.boot.minidouban.dao.MCommentDao;
import qqsrx.spring.boot.minidouban.domain.MComment;
import qqsrx.spring.boot.minidouban.service.MCommentService;

import java.util.List;

@Service
public class MCommentServiceImpl implements MCommentService {
    @Autowired
    private MCommentDao mCommentDao;

    @Override
    public int add(MComment mComment) {
        return mCommentDao.add(mComment);
    }

    @Override
    public List<MComment> getCommentListByMId(int momentId) {
        return mCommentDao.getCommentListByMId(momentId);
    }
}
