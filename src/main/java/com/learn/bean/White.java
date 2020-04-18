package com.learn.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class White {
    public White() {
        System.out.println("white new");
    }
    @PostConstruct
    public void init(){
        System.out.println("white init");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("white destroy");
    }
}
