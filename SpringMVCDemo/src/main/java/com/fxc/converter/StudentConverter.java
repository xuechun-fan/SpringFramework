package com.fxc.converter;

import com.fxc.entities.Student;
import org.springframework.core.convert.converter.Converter;

/**
 * Description：
 */
public class StudentConverter implements Converter<String, Student> {

    @Override
    public Student convert(String s) {
        String[] info = s.split("-");
        Student student = new Student();
        student.setId(Integer.parseInt(info[0]));
        student.setName(info[1]);
        student.setAge(Integer.parseInt(info[2]));
        return student;
    }
}
