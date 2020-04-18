package com.learn.config;

import com.learn.bean.Color;
import com.learn.bean.Person;
import com.learn.bean.Red;
import com.learn.condition.LinuxCondition;
import com.learn.condition.WindowCondition;
import org.springframework.context.annotation.*;
@Conditional(value = {WindowCondition.class})
@Configuration
@Import({Color.class,Red.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {
    @Lazy
    @Scope
    @Bean("person")
    public Person person(){
        System.out.println("person添加类到容器中");
        return new Person("yancy2",30);
    }

    @Conditional(value = {WindowCondition.class})
    @Bean("window")
    public Person person1(){
        return new Person("window",888);
    }
    @Conditional(value = {LinuxCondition.class})
    @Bean("linux")
    public Person person2(){
        return new Person("linux",888);
    }

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
