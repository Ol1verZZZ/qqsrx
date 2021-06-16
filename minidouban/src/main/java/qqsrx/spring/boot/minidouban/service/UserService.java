package qqsrx.spring.boot.minidouban.service;

import qqsrx.spring.boot.minidouban.domain.User;

import java.util.List;

public interface UserService {
    User getUserById(int userId);
    public List<User> getUserList();
    public int add(User user);
    public int update(int userId, User user);
    public int delete(int userId);
}
