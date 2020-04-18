package com.learn.config;

import com.learn.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.learn.bean")
@PropertySource(value = {"classpath:/person.properties"})
public class MainConfigOfPropertyValue {
    @Bean
    public Person person(){
        return new Person("yancy",30);
    }
}
