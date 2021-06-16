package qqsrx.spring.boot.minidouban.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qqsrx.spring.boot.minidouban.domain.User;
import qqsrx.spring.boot.minidouban.dao.UserDao;
import qqsrx.spring.boot.minidouban.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(int userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public int add(User user) {
        return userDao.add(user);
    }

    @Override
    public int update(int userId, User user) {
        return userDao.update(userId, user);
    }

    @Override
    public int delete(int userId) {
        return userDao.delete(userId);
    }
}
