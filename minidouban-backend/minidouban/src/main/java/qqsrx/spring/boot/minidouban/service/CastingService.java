package qqsrx.spring.boot.minidouban.service;

import qqsrx.spring.boot.minidouban.domain.Casting;

import java.util.List;

public interface CastingService {
    public List<Casting> getCastingListByIMDb(String imdbId);
}
