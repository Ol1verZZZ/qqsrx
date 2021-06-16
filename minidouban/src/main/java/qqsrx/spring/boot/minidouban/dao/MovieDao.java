package qqsrx.spring.boot.minidouban.dao;

import qqsrx.spring.boot.minidouban.domain.Movie;

import java.util.List;

public interface MovieDao {
    public List<Movie> getHotMovieList();
    public Movie getMovieById(String imdbId);
}
