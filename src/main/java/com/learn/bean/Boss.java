package com.learn.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Boss {
    private Car car;

    @Autowired
    public Boss(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    @Autowired
    public void setCar(@Autowired Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
