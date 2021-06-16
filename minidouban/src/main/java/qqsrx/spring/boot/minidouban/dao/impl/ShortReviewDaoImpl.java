package qqsrx.spring.boot.minidouban.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import qqsrx.spring.boot.minidouban.dao.ShortReviewDao;
import qqsrx.spring.boot.minidouban.domain.Intention;
import qqsrx.spring.boot.minidouban.domain.ShortReview;

import java.util.Date;
import java.util.List;

@Repository
public class ShortReviewDaoImpl implements ShortReviewDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ShortReview> getSRListByIMDbId(String imdbId) {
        String sql = "SELECT * FROM short_review WHERE imdbId = ?";
        List<ShortReview> list = jdbcTemplate.query(sql, new Object[]{imdbId}, new int[]{12},
                new BeanPropertyRowMapper<>(ShortReview.class));
        if(list!=null&&list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    @Override
    public int add(ShortReview sr) {
        String sql = "INSERT INTO short_review(imdbId, user_id, rate, sr_content, sr_post_time) VALUES(?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql, sr.getImdbId(), sr.getUserId(), sr.getRate(), sr.getSrContent(), new Date());
    }

    @Override
    public int update(String imdbId, int userId, ShortReview sr) {
        String sql = "UPDATE short_review SET rate=?, sr_content=? WHERE user_id=? AND imdbId=?";

        return jdbcTemplate.update(sql, sr.getRate(), sr.getSrContent(), userId, imdbId);
    }

    @Override
    public int delete(String imdbId, int userId) {
        String sql = "DELETE FROM short_review WHERE imdbId = ? AND user_id = ?";

        return jdbcTemplate.update(sql, imdbId, userId);
    }

    @Override
    public boolean hasWatched(String imdbId, int userId) {
        String sql = "SELECT * FROM short_review WHERE user_id = ? AND imdbId = ?";
        List<ShortReview> list = jdbcTemplate.query(sql, new Object[]{userId, imdbId},
                new int[]{4, 12}, new BeanPropertyRowMapper<>(ShortReview.class));

        if(list!=null&&list.size()>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<ShortReview> getSRListByUserId(int userId) {
        String sql = "SELECT * FROM short_review WHERE user_id = ? ORDER BY UNIX_TIMESTAMP(sr_post_time) DESC";
        List<ShortReview> list = jdbcTemplate.query(sql, new Object[]{userId}, new int[]{4},
                new BeanPropertyRowMapper<>(ShortReview.class));

        if(list!=null&&list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
