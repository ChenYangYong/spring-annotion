package com.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan(
        value = {"com.web"},
        excludeFilters = {@ComponentScan.Filter(type=FilterType.ANNOTATION,classes = {Controller.class,RestController.class})}
)
public class RootConfig {
}
