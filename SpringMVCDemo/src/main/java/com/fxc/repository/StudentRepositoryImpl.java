package com.fxc.repository;

import com.fxc.entities.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Description：
 */

@Repository
public class StudentRepositoryImpl implements StudentRepository{
    private static Map<Integer, Student> studentMap;

    static{

        //  模拟数据库功能
        studentMap = new HashMap<>();
//        studentMap.put(1, new Student(1, "张三", 22, false, null, null));
//        studentMap.put(2, new Student(2, "李四", 29, false, null, null));
//        studentMap.put(3, new Student(3, "王五", 20, false, null, null));
    }

    @Override
    public Collection<Student> findAll() {
        return studentMap.values();
    }

    @Override
    public Student findById(int id) {
        return studentMap.get(id);
    }

    @Override
    public void saveOrUpdate(Student student) {
        studentMap.put(student.getId(), student);
    }

    @Override
    public void deleteById(int id) {
        studentMap.remove(id);
    }
}
