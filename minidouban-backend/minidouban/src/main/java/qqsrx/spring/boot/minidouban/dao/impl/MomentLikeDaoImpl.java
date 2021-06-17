package qqsrx.spring.boot.minidouban.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import qqsrx.spring.boot.minidouban.dao.MomentLikeDao;
import qqsrx.spring.boot.minidouban.domain.MomentLike;
import qqsrx.spring.boot.minidouban.domain.SRLike;

import java.util.List;

@Repository
public class MomentLikeDaoImpl implements MomentLikeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(MomentLike momentLike) {
        String sql = "INSERT INTO moment_like(user_id, moment_id) VALUES(?, ?)";

        return jdbcTemplate.update(sql, momentLike.getUserId(), momentLike.getMomentId());
    }

    @Override
    public int delete(int userId, int momentId) {
        String sql = "DELETE FROM moment_like WHERE user_id = ? AND moment_id = ?";

        return jdbcTemplate.update(sql, userId, momentId);
    }

    @Override
    public int getMomentLikeSum(int momentId) {
        String sql = "SELECT COUNT(*) FROM moment_like WHERE moment_id = ?";

        Integer srLikeSum = jdbcTemplate.queryForObject(sql, new Object[]{momentId},
                new int[]{4}, Integer.class);

        return srLikeSum.intValue();
    }

    @Override
    public boolean hasLiked(int userId, int momentId) {
        String sql = "SELECT * FROM moment_like WHERE user_id = ? AND moment_id = ?";
        List<MomentLike> list = jdbcTemplate.query(sql, new Object[]{userId, momentId},
                new int[]{4, 4}, new BeanPropertyRowMapper<>(MomentLike.class));

        if(list!=null&&list.size()>0){
            return true;
        }else{
            return false;
        }
    }
}
