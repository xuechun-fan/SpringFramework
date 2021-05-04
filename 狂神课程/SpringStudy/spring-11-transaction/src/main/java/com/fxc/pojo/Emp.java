package com.fxc.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    private int id;
    private String name;
    private int age;
    private int deptId;
    private int empno;

}