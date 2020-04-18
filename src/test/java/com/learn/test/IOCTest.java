package com.learn.test;

import com.learn.bean.Dog;
import com.learn.config.ColorFactoryBean;
import com.learn.config.MainConfig;
import com.learn.config.MainConfig2;
import com.learn.config.MainConfigOfAutowired;
import com.learn.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class IOCTest {
    @Test
    public void testAutowired(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        printAllBeanName(applicationContext);
        BookService bookService = (BookService)applicationContext.getBean("bookService");
        bookService.print();
        System.out.println(applicationContext.getBean("bookDao"));
        System.out.println(applicationContext.getBean("bookDao2"));
        System.out.println(applicationContext.getBean("boss"));
        System.out.println(applicationContext.getBean("staff"));


    }
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void testImport(){
        printAllBeanName(applicationContext);
        System.out.println(applicationContext.getBean(Dog.class.getName()));
        System.out.println(applicationContext.getBean("colorFactoryBean"));
        System.out.println(applicationContext.getBean("&colorFactoryBean"));
    }
    private void printAllBeanName(ApplicationContext applicationContext){
        String[] beanDefins = applicationContext.getBeanDefinitionNames();
        for(String name:beanDefins){
            System.out.println(name);
        }
    }
    @Test
    public void test03(){
        Environment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
        String[] beanDefins = applicationContext.getBeanDefinitionNames();
        for(String name:beanDefins){
            System.out.println(name);
        }
    }
    @Test
    public void test02(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] beanDefins = applicationContext.getBeanDefinitionNames();
        for(String name:beanDefins){
            System.out.println(name);
        }
        Object bean = applicationContext.getBean("person");
        Object bean1 = applicationContext.getBean("person");
        System.out.println(bean==bean1);
    }

    @Test
    public void test01(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefins = applicationContext.getBeanDefinitionNames();
        for(String name:beanDefins){
            System.out.println(name);
        }
    }
}
