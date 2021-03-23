package com.fxc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int id;
    private String name;
    private int age;
    private boolean flag;
//    private String[] hobby;
    private List<String> hobby;
    private List<String> selectHobby;
    private int radioId;
    private Map<Integer, String> gradeMap;
    private int selectGrade;

    private Map<Integer, String> cityMap;
    private int selectCity;
    private String introduce;

}
