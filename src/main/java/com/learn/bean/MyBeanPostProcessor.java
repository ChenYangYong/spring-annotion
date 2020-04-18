package com.learn.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * bean赋值，注入其它组件，@Autowired,生命周期注解功能，@Async，
 * 等等都是通过BeanPostProcessor的实现类来实现的
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println(o+" postProcessBeforeInitialization");
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println(o+" postProcessAfterInitialization");
        return o;
    }
}
