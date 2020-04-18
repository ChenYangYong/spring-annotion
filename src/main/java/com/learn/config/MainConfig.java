package com.learn.config;

import com.learn.bean.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Configuration
//@ComponentScan(
//        value = {"com.learn"},
////        excludeFilters = {@ComponentScan.Filter(type=FilterType.ANNOTATION,classes = {Controller.class})},
//        includeFilters = {@ComponentScan.Filter(type=FilterType.ANNOTATION,classes = {Controller.class})},
//        useDefaultFilters = false
//)
@ComponentScans(value = {
        @ComponentScan(
                value = {"com.learn"},
//        excludeFilters = {@ComponentScan.Filter(type=FilterType.ANNOTATION,classes = {Controller.class})},
                includeFilters = {
//                        @ComponentScan.Filter(type=FilterType.ANNOTATION,classes = {Controller.class}),
                        @ComponentScan.Filter(type=FilterType.CUSTOM,classes = {MyTypeFilter.class}),
                },
                useDefaultFilters = false
        )
})
public class MainConfig {

    @Bean
    public Person person(){
        return new Person("yancy",30);
    }
}
