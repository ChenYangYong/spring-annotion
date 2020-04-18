package com.learn.bean;

import org.springframework.stereotype.Component;

public class Staff {
    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "car=" + car +
                '}';
    }
}
