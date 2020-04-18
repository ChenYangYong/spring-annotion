package com.learn.config;

import com.learn.bean.Car;
import com.learn.bean.Staff;
import com.learn.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(value = {"com.learn.dao","com.learn.bean","com.learn.service"})
public class MainConfigOfAutowired {

    @Primary
    @Bean("bookDao2")
    public BookDao bookDao(){
        return new BookDao("2");
    }

    /**
     *
     * @param car  默认会从容器中取出赋值
     * @return
     */
    @Bean
    public Staff staff(Car car){
        Staff s = new Staff();
        s.setCar(car);
        return s;
    }
}
