package com.fxc.controller;

import com.fxc.entities.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Description：
 */
@RestController
@RequestMapping("/converter")
public class ConverterHandler {
    @RequestMapping("/date")
    public String date(Date date){
        return date.toString();
    }
    @RequestMapping("/student")
    public String student(Student student){
        return student.toString();
    }
}
