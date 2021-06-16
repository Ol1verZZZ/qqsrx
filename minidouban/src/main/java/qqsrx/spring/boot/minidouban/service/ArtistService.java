package qqsrx.spring.boot.minidouban.service;

import qqsrx.spring.boot.minidouban.domain.Artist;

public interface ArtistService {
    public Artist getArtistById(String imdbArtistId);
}
