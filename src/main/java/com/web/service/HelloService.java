package com.web.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public void hello(String name){
        System.out.println("HelloService.hello say hello to:"+name);
    }
}
