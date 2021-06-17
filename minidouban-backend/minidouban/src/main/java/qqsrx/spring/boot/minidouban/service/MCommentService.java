package qqsrx.spring.boot.minidouban.service;

import qqsrx.spring.boot.minidouban.domain.MComment;

import java.util.List;

public interface MCommentService {
    public int add(MComment mComment);
    public List<MComment> getCommentListByMId(int momentId);
}
