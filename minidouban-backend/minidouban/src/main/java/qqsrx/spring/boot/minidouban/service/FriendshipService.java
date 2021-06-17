package qqsrx.spring.boot.minidouban.service;

import qqsrx.spring.boot.minidouban.domain.Friendship;

import java.util.List;

public interface FriendshipService {
    public int add(Friendship friendship);
    public int delete(int fromId, int toId);
    public List<Friendship> getFollowingList(int userId);
    public List<Friendship> getFollowedList(int userId);
}
