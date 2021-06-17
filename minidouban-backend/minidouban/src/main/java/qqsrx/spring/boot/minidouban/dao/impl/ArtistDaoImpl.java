package qqsrx.spring.boot.minidouban.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import qqsrx.spring.boot.minidouban.dao.ArtistDao;
import qqsrx.spring.boot.minidouban.domain.Artist;

import java.util.List;

@Repository
public class ArtistDaoImpl implements ArtistDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Artist getArtistById(String imdbArtistId) {
        String sql = "SELECT * FROM artist WHERE IMDb_artist_id = ?";
        List<Artist> list = jdbcTemplate.query(sql, new Object[]{imdbArtistId},
                new int[]{12}, new BeanPropertyRowMapper<>(Artist.class));
        if(list!=null&&list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }
}
