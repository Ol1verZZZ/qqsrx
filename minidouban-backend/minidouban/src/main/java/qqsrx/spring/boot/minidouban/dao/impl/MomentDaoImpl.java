package qqsrx.spring.boot.minidouban.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import qqsrx.spring.boot.minidouban.dao.MomentDao;
import qqsrx.spring.boot.minidouban.domain.Moment;

import java.util.Date;
import java.util.List;

@Repository
public class MomentDaoImpl implements MomentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Moment moment) {
        String sql = "INSERT INTO moment(user_id, moment_content, moment_post_time) VALUES(?, ?, ?)";

        return jdbcTemplate.update(sql, moment.getUserId(), moment.getMomentContent(), new Date());
    }

    @Override
    public List<Moment> getAllMoments() {
        String sql = "SELECT * FROM moment ORDER BY UNIX_TIMESTAMP(moment_post_time) DESC";
        List<Moment> list = jdbcTemplate.query(sql, new Object[]{}, new int[]{},
                new BeanPropertyRowMapper<>(Moment.class));

        if(list!=null&&list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    @Override
    public List<Moment> getMomentListByUserId(int userId) {
        String sql = "SELECT * FROM moment WHERE user_id = ?";
        List<Moment> list = jdbcTemplate.query(sql, new Object[]{userId}, new int[]{4},
                new BeanPropertyRowMapper<>(Moment.class));

        if(list!=null&&list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
