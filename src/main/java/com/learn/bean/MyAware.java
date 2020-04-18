package com.learn.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

@Component
public class MyAware implements ApplicationContextAware,EmbeddedValueResolverAware,BeanNameAware,EnvironmentAware {
    private ApplicationContext applicationContext;
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("ApplicationContextAware.setApplicationContext: "+applicationContext);
    }

    public void setBeanName(String s) {
        System.out.println("BeanNameAware.setBeanName: "+s);
    }

    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {

        System.out.println("EmbeddedValueResolverAware.setEmbeddedValueResolver: "+stringValueResolver);
        System.out.println(stringValueResolver.resolveStringValue("你好${os.name},#{888*888}"));

    }

    public void setEnvironment(Environment environment) {
        System.out.println("EnvironmentAware.setEnvironment: "+environment);
    }
}
