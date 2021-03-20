package com.fxc.factory;

import com.fxc.entity.Car;

import java.util.HashMap;
import java.util.Map;

public class StaticCarFactory {
    private static Map<Integer, Car> carMap;
    static{
        carMap = new HashMap<Integer, Car>();
        carMap.put(1, new Car(1, "宝马"));
        carMap.put(2, new Car(2, "奔驰"));

    }
    public static Car getCar(Integer id){
        return carMap.get(id);
    }
}
