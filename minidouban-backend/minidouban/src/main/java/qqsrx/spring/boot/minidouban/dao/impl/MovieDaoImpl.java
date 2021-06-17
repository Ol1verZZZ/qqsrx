package qqsrx.spring.boot.minidouban.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import qqsrx.spring.boot.minidouban.dao.MovieDao;
import qqsrx.spring.boot.minidouban.domain.Movie;

import java.util.List;

@Repository
public class MovieDaoImpl implements MovieDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Movie> getHotMovieList() {
        String sql = "SELECT * FROM movie;";
        List<Movie> list = jdbcTemplate.query(sql, new Object[]{}, new int[]{},
                new BeanPropertyRowMapper<>(Movie.class));
        if(list!=null&&list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    @Override
    public Movie getMovieById(String imdbId) {
        String sql = "SELECT * FROM movie WHERE imdbId = ?";
        List<Movie> list = jdbcTemplate.query(sql, new Object[]{imdbId}, new int[]{12},
                new BeanPropertyRowMapper<>(Movie.class));
        if(list!=null&&list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }
}
