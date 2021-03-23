package com.fxc.controller;

import com.fxc.entities.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description：
 */
@Controller
@RequestMapping("/tag")
public class TagHandler {

    @GetMapping("/get")
    public ModelAndView get(){
        ModelAndView modelAndView = new ModelAndView("show");
        Student student = new Student();
        student.setId(1);
        student.setName("李华");
        student.setAge(22);
//        student.setHobby(new String[]{"打球", "听音乐", "睡觉"});
        student.setHobby(Arrays.asList("打球", "听音乐", "睡觉", "读书", "旅游","看电视"));
        student.setSelectHobby(Arrays.asList("打球", "听音乐", "旅游"));
        student.setRadioId(99);
        Map<Integer,String> gradeMap = new HashMap<>();
        gradeMap.put(1,"一年级");
        gradeMap.put(2,"二年级");
        gradeMap.put(3,"三年级");
        gradeMap.put(4,"四年级");
        gradeMap.put(5,"五年级");
        gradeMap.put(6,"六年级");
        student.setGradeMap(gradeMap);
        student.setSelectGrade(3);

        Map<Integer, String> cityMap = new HashMap<>();
        cityMap.put(1, "北京");
        cityMap.put(2, "深圳");
        cityMap.put(3, "上海");
        cityMap.put(4, "广州");
        cityMap.put(5, "香港");
        student.setCityMap(cityMap);
        student.setSelectCity(2);

        student.setIntroduce("您好，我是小菜比。");

        modelAndView.addObject("student", student);
        return modelAndView;
    }

}
