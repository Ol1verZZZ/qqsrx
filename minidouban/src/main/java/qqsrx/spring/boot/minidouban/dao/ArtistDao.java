package qqsrx.spring.boot.minidouban.dao;

import qqsrx.spring.boot.minidouban.domain.Artist;

public interface ArtistDao {
    public Artist getArtistById(String imdbArtistId);
}
