package qqsrx.spring.boot.minidouban.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import qqsrx.spring.boot.minidouban.dao.FriendshipDao;
import qqsrx.spring.boot.minidouban.domain.Friendship;

import java.util.List;

@Repository
public class FriendshipDaoImpl implements FriendshipDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Friendship friendship) {
        String sql = "INSERT INTO friendship(from_id, to_id) VALUES(?, ?)";

        return jdbcTemplate.update(sql, friendship.getFromId(), friendship.getToId());
    }

    @Override
    public int delete(int fromId, int toId) {
        String sql = "DELETE FROM friendship WHERE from_id = ? AND to_id = ?";

        return jdbcTemplate.update(sql, fromId, toId);
    }

    @Override
    public List<Friendship> getFollowingList(int userId) {
        String sql = "SELECT * FROM friendship WHERE from_id = ?";

        List<Friendship> list = jdbcTemplate.query(sql, new Object[]{userId},
                new int[]{4}, new BeanPropertyRowMapper<>(Friendship.class));

        if(list!=null&&list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    @Override
    public List<Friendship> getFollowedList(int userId) {
        String sql = "SELECT * FROM friendship WHERE to_id = ?";

        List<Friendship> list = jdbcTemplate.query(sql, new Object[]{userId},
                new int[]{4}, new BeanPropertyRowMapper<>(Friendship.class));

        if(list!=null&&list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
