package qqsrx.spring.boot.minidouban.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qqsrx.spring.boot.minidouban.dao.MovieDao;
import qqsrx.spring.boot.minidouban.domain.Movie;
import qqsrx.spring.boot.minidouban.service.MovieService;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieDao movieDao;

    @Override
    public List<Movie> getHotMovieList() {
        return movieDao.getHotMovieList();
    }

    @Override
    public Movie getMovieById(String imdbId) {
        return movieDao.getMovieById(imdbId);
    }
}
