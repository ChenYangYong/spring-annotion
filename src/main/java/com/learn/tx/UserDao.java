package com.learn.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void insert(){
        String sql = "INSERT INTO `user`(age,name,sex) VALUES (?, ?, ?)";
        String name = UUID.randomUUID().toString().substring(0,5);
        jdbcTemplate.update(sql,18,name,"M");
    }
}
