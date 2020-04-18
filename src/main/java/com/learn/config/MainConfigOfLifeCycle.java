package com.learn.config;

import com.learn.bean.Black;
import com.learn.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.learn.bean")
public class MainConfigOfLifeCycle {

    @Bean(initMethod = "init",destroyMethod = "destroy" )
    public Car car(){
        return new Car();
    }
    @Bean
    public Black black(){
        return new Black();
    }
}
