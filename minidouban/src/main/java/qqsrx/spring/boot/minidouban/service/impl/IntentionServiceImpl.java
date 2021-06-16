package qqsrx.spring.boot.minidouban.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qqsrx.spring.boot.minidouban.dao.IntentionDao;
import qqsrx.spring.boot.minidouban.domain.Intention;
import qqsrx.spring.boot.minidouban.service.IntentionService;

import java.util.List;

@Service
public class IntentionServiceImpl implements IntentionService {
    @Autowired
    private IntentionDao intentionDao;

    @Override
    public int add(Intention intention) {
        return intentionDao.add(intention);
    }

    @Override
    public int delete(int userId, String imdbId) {
        return intentionDao.delete(userId, imdbId);
    }

    @Override
    public boolean hasIntention(int userId, String imdbId) {
        return intentionDao.hasIntention(userId, imdbId);
    }

    @Override
    public List<Intention> getIntentionListByUserId(int userId) {
        return intentionDao.getIntentionListByUserId(userId);
    }
}
