package qqsrx.spring.boot.minidouban.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import qqsrx.spring.boot.minidouban.dao.SRLikeDao;
import qqsrx.spring.boot.minidouban.domain.SRLike;

import java.util.List;

@Repository
public class SRLikeDaoImpl implements SRLikeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(SRLike srLike) {
        String sql = "INSERT INTO sr_like(owner_id, imdbId, user_id) VALUES(?, ?, ?)";

        return jdbcTemplate.update(sql, srLike.getOwnerId(), srLike.getImdbId(), srLike.getUserId());
    }

    @Override
    public int delete(String imdbId, int ownerId, int userId) {
        String sql = "DELETE FROM sr_like WHERE owner_id = ? AND imdbId = ? AND user_id = ?";

        return jdbcTemplate.update(sql, ownerId, imdbId, userId);
    }

    @Override
    public int getSRLikeSum(String imdbId, int ownerId) {
        String sql = "SELECT COUNT(*) FROM sr_like WHERE imdbId = ? AND owner_id = ?";

        Integer srLikeSum = jdbcTemplate.queryForObject(sql, new Object[]{imdbId, ownerId},
                new int[]{12, 4}, Integer.class);

        return srLikeSum.intValue();
    }

    @Override
    public boolean hasLiked(String imdbId, int ownerId, int userId) {
        String sql = "SELECT * FROM sr_like WHERE owner_id = ? AND imdbId = ? AND user_id = ?";
        List<SRLike> list = jdbcTemplate.query(sql, new Object[]{ownerId, imdbId, userId},
                new int[]{4, 12, 4}, new BeanPropertyRowMapper<>(SRLike.class));

        if(list!=null&&list.size()>0){
            return true;
        }else{
            return false;
        }
    }
}
