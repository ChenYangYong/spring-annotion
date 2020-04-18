package com.learn.test;

import com.learn.config.MainConfigOfLifeCycle;
import com.learn.config.MainConfigOfPropertyValue;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class PropertyValueTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValue.class);
    @Test
    public void test1(){
        printAllBeanName(applicationContext);
        System.out.println(applicationContext.getBean("person"));
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        System.out.println(environment.getProperty("nickName"));

    }
    private void printAllBeanName(ApplicationContext applicationContext){
        String[] beanDefins = applicationContext.getBeanDefinitionNames();
        for(String name:beanDefins){
            System.out.println(name);
        }
    }
}
