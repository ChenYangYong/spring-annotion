package com.learn.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class MyListener {
    @EventListener(classes = {ApplicationEvent.class})
    public void listener(Object o){
        System.out.println("MyListener.listener监听到="+o);
    }
}
