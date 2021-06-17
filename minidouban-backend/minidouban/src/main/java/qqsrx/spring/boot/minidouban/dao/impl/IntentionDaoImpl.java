package qqsrx.spring.boot.minidouban.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import qqsrx.spring.boot.minidouban.dao.IntentionDao;
import qqsrx.spring.boot.minidouban.domain.Intention;

import java.util.Date;
import java.util.List;

@Repository
public class IntentionDaoImpl implements IntentionDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Intention intention) {
        String sql = "INSERT INTO intention(user_id, imdbId, mark_time, mark_description) VALUES(?, ?, ?, ?)";

        return jdbcTemplate.update(sql, intention.getUserId(), intention.getImdbId(),
                new Date(), intention.getMarkDescription());
    }

    @Override
    public int delete(int userId, String imdbId) {
        String sql = "DELETE FROM intention WHERE user_id = ? AND imdbId = ?";

        return jdbcTemplate.update(sql, userId, imdbId);
    }

    @Override
    public boolean hasIntention(int userId, String imdbId) {
        String sql = "SELECT * FROM intention WHERE user_id = ? AND imdbId = ?";
        List<Intention> list = jdbcTemplate.query(sql, new Object[]{userId, imdbId},
                new int[]{4, 12}, new BeanPropertyRowMapper<>(Intention.class));

        if(list!=null&&list.size()>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Intention> getIntentionListByUserId(int userId) {
        String sql = "SELECT * FROM intention WHERE user_id = ? ORDER BY UNIX_TIMESTAMP(mark_time) DESC";
        List<Intention> list = jdbcTemplate.query(sql, new Object[]{userId}, new int[]{4},
                new BeanPropertyRowMapper<>(Intention.class));

        if(list!=null&&list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
