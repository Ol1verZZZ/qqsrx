package qqsrx.spring.boot.minidouban.dao;

import qqsrx.spring.boot.minidouban.domain.Intention;

import java.util.List;

public interface IntentionDao {
    public int add(Intention intention);
    public int delete(int userId, String imdbId);
    public boolean hasIntention(int userId, String imdbId);
    public List<Intention> getIntentionListByUserId(int userId);
}
