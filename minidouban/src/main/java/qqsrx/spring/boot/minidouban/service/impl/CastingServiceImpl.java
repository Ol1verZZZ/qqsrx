package qqsrx.spring.boot.minidouban.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qqsrx.spring.boot.minidouban.dao.CastingDao;
import qqsrx.spring.boot.minidouban.domain.Casting;
import qqsrx.spring.boot.minidouban.service.CastingService;

import java.util.List;

@Service
public class CastingServiceImpl implements CastingService {
    @Autowired
    private CastingDao castingDao;

    @Override
    public List<Casting> getCastingListByIMDb(String imdbId) {
        return castingDao.getCastingListByIMDb(imdbId);
    }
}
