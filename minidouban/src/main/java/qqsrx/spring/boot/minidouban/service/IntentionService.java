package qqsrx.spring.boot.minidouban.service;

import qqsrx.spring.boot.minidouban.domain.Intention;

import java.util.List;

public interface IntentionService {
    public int add(Intention intention);
    public int delete(int userId, String imdbId);
    public boolean hasIntention(int userId, String imdbId);
    public List<Intention> getIntentionListByUserId(int userId);
}
