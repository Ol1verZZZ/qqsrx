package qqsrx.spring.boot.minidouban.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import qqsrx.spring.boot.minidouban.dao.MCommentDao;
import qqsrx.spring.boot.minidouban.domain.MComment;
import qqsrx.spring.boot.minidouban.domain.ShortReview;

import java.util.Date;
import java.util.List;

@Repository
public class MCommentDaoImpl implements MCommentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(MComment mComment) {
        String sql = "INSERT INTO m_comment(comment_id, moment_id, user_id, to_user_id, comment_content, comment_time) " +
                "VALUES(?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql, mComment.getCommentId(), mComment.getMomentId(), mComment.getUserId(),
                mComment.getToUserId(), mComment.getCommentContent(), new Date());
    }

    @Override
    public List<MComment> getCommentListByMId(int momentId) {
        String sql = "SELECT * FROM m_comment WHERE moment_id = ? ORDER BY UNIX_TIMESTAMP(comment_time) ASC";
        List<MComment> list = jdbcTemplate.query(sql, new Object[]{momentId}, new int[]{4},
                new BeanPropertyRowMapper<>(MComment.class));

        if(list!=null&&list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
