package com.fxc.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
//  员工表
public class Employee {
    private Integer id;
    private String name;
    private String email;
    private Integer gender;     // 0:女  1：男
    private Integer department;
    private String birth;
}