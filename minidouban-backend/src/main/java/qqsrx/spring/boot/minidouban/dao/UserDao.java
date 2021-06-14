package qqsrx.spring.boot.minidouban.dao;

import qqsrx.spring.boot.minidouban.domain.User;
import java.util.List;

public interface UserDao {
    public User getUserById(Integer userId);
    public List<User> getUserList();
    public int add(User user);
    public int update(Integer userId, User user);
    public int delete(Integer userId);
}
