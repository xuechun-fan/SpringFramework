package com.fxc.repository;

import com.fxc.entity.Student;

public interface StudentRepository {
    public Student findById(int id);
}
