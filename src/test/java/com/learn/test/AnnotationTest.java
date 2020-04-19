package com.learn.test;

import com.learn.aop.MathCalculator;
import com.learn.bean.Dog;
import com.learn.config.*;
import com.learn.ext.ExtConfig;
import com.learn.service.BookService;
import com.learn.tx.TxConfig;
import com.learn.tx.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class AnnotationTest {
    @Test
    public void testExt(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);
        applicationContext.publishEvent(new ApplicationEvent("event") {
            @Override
            public Object getSource() {
                return super.getSource();
            }
        });
//        printAllBeanName(applicationContext);
    }
    @org.junit.Test
    public void testTx(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
//        printAllBeanName(applicationContext);
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.insertUser();
    }
    @org.junit.Test
    public void testAop(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAop.class);
        printAllBeanName(applicationContext);
        MathCalculator calculator = (MathCalculator) applicationContext.getBean("mathCalculator");
        System.out.println(calculator.div(10,0));
    }
    @org.junit.Test
    public void testProfile(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.getEnvironment().setActiveProfiles("prod");
        applicationContext.register(MainConfigOfProfile.class);
        applicationContext.refresh();
        printAllBeanName(applicationContext);
    }
    @org.junit.Test
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

    @org.junit.Test
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
    @org.junit.Test
    public void test03(){
        Environment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
        String[] beanDefins = applicationContext.getBeanDefinitionNames();
        for(String name:beanDefins){
            System.out.println(name);
        }
    }
    @org.junit.Test
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

    @org.junit.Test
    public void test01(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefins = applicationContext.getBeanDefinitionNames();
        for(String name:beanDefins){
            System.out.println(name);
        }
    }
}
