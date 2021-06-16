package qqsrx.spring.boot.minidouban.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import qqsrx.spring.boot.minidouban.dao.CastingDao;
import qqsrx.spring.boot.minidouban.domain.Artist;
import qqsrx.spring.boot.minidouban.domain.Casting;

import java.util.List;

@Repository
public class CastingDaoImpl implements CastingDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Casting> getCastingListByIMDb(String imdbId) {
        String sql = "SELECT * FROM casting WHERE imdbId = ?";

        List<Casting> list = jdbcTemplate.query(sql, new Object[]{imdbId}, new int[]{12},
                new BeanPropertyRowMapper<>(Casting.class));

        if(list!=null&&list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
