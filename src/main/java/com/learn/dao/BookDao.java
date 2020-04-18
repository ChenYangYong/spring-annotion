package com.learn.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
    private String lable ;

    public BookDao() {
    }

    public BookDao(String lable) {
        this.lable = lable;
    }

    @Override
    public String toString() {
        return "BookDao{" +
                "lable='" + lable + '\'' +
                '}';
    }
}
