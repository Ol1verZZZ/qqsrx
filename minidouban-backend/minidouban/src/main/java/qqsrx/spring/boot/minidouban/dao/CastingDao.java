package qqsrx.spring.boot.minidouban.dao;

import qqsrx.spring.boot.minidouban.domain.Casting;

import java.util.List;

public interface CastingDao {
    public List<Casting> getCastingListByIMDb(String imdbId);
}
