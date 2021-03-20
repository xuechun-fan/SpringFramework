package com.fxc.entity;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    private Classes classes;
}
