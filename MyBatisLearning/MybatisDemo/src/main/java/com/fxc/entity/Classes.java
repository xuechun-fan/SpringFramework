package com.fxc.entity;

import lombok.Data;

import java.util.List;

@Data
public class Classes {
    private int id;
    private String name;
    private List<Student> students;
}
