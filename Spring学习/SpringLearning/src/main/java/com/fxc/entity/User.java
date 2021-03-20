package com.fxc.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private List<Address> addresses;

    public User() {
        System.out.println("调用 User 无参构造函数");
    }
}
