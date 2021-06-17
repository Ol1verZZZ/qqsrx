package qqsrx.spring.boot.minidouban.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qqsrx.spring.boot.minidouban.dao.ArtistDao;
import qqsrx.spring.boot.minidouban.domain.Artist;
import qqsrx.spring.boot.minidouban.service.ArtistService;

@Service
public class ArtistServiceImpl implements ArtistService {
    @Autowired
    private ArtistDao artistDao;

    @Override
    public Artist getArtistById(String imdbArtistId) {
        return artistDao.getArtistById(imdbArtistId);
    }
}
