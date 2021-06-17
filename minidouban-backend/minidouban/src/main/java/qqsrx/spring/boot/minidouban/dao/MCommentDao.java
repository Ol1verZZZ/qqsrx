package qqsrx.spring.boot.minidouban.dao;

import qqsrx.spring.boot.minidouban.domain.MComment;

import java.util.List;

public interface MCommentDao {
    public int add(MComment mComment);
    public List<MComment> getCommentListByMId(int momentId);
}
