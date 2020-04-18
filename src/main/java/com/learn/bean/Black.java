package com.learn.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Black implements InitializingBean,DisposableBean {
    public void destroy() throws Exception {
        System.out.println("Black  destroy");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Black  afterPropertiesSet");
    }
}
