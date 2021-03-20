package com.fxc.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class Student {
    private int id;
    private String name;
    private int age;
    private List<Address> addresses;
    private double score;

    public Student() {
        System.out.println("调用了Student无参构造函数");
    }
}
