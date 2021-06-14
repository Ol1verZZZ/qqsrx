package qqsrx.spring.boot.minidouban.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;
import qqsrx.spring.boot.minidouban.dao.UserDao;
import qqsrx.spring.boot.minidouban.domain.User;

import java.util.Date;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

//    @Autowired
//    public UserDaoImpl(JdbcTemplate jdbcTemplate){
//        this.jdbcTemplate = jdbcTemplate;
//    }

    @Override
    public User getUserById(Integer userId) {
        List<User> list = jdbcTemplate.query("SELECT * FROM user WHERE user_id = ?",
                new Object[]{userId}, new int[]{4}, new BeanPropertyRowMapper<>(User.class));
        if(list!=null&&list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }

    @Override
    public List<User> getUserList() {
        List<User> list = jdbcTemplate.query("SELECT * FROM user",
                new Object[]{}, new int[]{}, new BeanPropertyRowMapper<>(User.class));
        if(list!=null&&list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    @Override
    public int add(User user) {
        return jdbcTemplate.update("INSERT INTO user(user_name, password, gender, register_date, is_admin) VALUES(?, ?, ?)",
                user.getUserName(), user.getPassword(), user.getGender(), new Date(), user.getIsAdmin());
    }

    @Override
    public int update(Integer userId, User user) {
        return jdbcTemplate.update("UPDATE user SET user_name=?, password=?, gender=?, is_admin=? WHERE user_id=?",
                user.getUserName(), user.getPassword(), user.getGender(), user.getIsAdmin(), userId);
    }

    @Override
    public int delete(Integer userId) {
        return jdbcTemplate.update("DELETE FROM user WHERE user_id=?", userId);
    }
}
