package com.fxc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//  部门表
public class Department {
    private Integer id;
    private String deptName;
}