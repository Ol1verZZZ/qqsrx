package qqsrx.spring.boot.minidouban.service;

import org.springframework.stereotype.Service;
import qqsrx.spring.boot.minidouban.domain.Movie;

import java.util.List;

public interface MovieService {
    public List<Movie> getHotMovieList();
    public Movie getMovieById(String imdbId);
}
