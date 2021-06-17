package qqsrx.spring.boot.minidouban.dao;

import qqsrx.spring.boot.minidouban.domain.Friendship;

import java.util.List;

public interface FriendshipDao {
    public int add(Friendship friendship);
    public int delete(int fromId, int toId);
    public List<Friendship> getFollowingList(int userId);
    public List<Friendship> getFollowedList(int userId);
}
