package com.fxc.test;

import com.fxc.entity.Car;
import com.fxc.factory.InstanceCarFactory;

public class TestInstanceCarFactory {
    public static void main(String[] args) {
        Car car = new InstanceCarFactory().getCar(1);
        System.out.println(car);
    }
}
