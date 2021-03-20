package com.fxc.test;

import com.fxc.entity.Car;
import com.fxc.factory.StaticCarFactory;

public class TestStaticCarFactory {
    public static void main(String[] args) {
        Car car1 = StaticCarFactory.getCar(1);
        Car car2 = StaticCarFactory.getCar(2);
        System.out.println(car1);
        System.out.println(car2);

    }
}
