package qqsrx.spring.boot.minidouban.dao;

import qqsrx.spring.boot.minidouban.domain.User;
import java.util.List;

public interface UserDao {
    public User getUserById(int userId);
    public User getUserByEmail(String email);
    public List<User> getUserList();
    public int add(User user);
    public int update(int userId, User user);
    public int delete(int userId);
    public boolean logIn(String email, String password);
}
