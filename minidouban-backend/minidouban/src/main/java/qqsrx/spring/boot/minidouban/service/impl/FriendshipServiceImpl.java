package qqsrx.spring.boot.minidouban.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qqsrx.spring.boot.minidouban.dao.FriendshipDao;
import qqsrx.spring.boot.minidouban.domain.Friendship;
import qqsrx.spring.boot.minidouban.service.FriendshipService;

import java.util.List;

@Service
public class FriendshipServiceImpl implements FriendshipService {
    @Autowired
    private FriendshipDao friendshipDao;

    @Override
    public int add(Friendship friendship) {
        return friendshipDao.add(friendship);
    }

    @Override
    public int delete(int fromId, int toId) {
        return friendshipDao.delete(fromId, toId);
    }

    @Override
    public List<Friendship> getFollowingList(int userId) {
        return friendshipDao.getFollowingList(userId);
    }

    @Override
    public List<Friendship> getFollowedList(int userId) {
        return friendshipDao.getFollowedList(userId);
    }
}
