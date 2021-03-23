package com.fxc.controller;

import com.fxc.entities.Student;
import com.fxc.entities.User;
import com.fxc.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

/**
 * Description：
 */
@RestController
@RequestMapping("/rest")
public class RESTHandler {
    @Autowired
    private StudentRepository studentRepository;

//    @RequestMapping(value="/findAll", method = RequestMethod.GET)
    @GetMapping("/findAll")     //  是上面注解的简写形式，功能一样，就是映射/findAll请求，并且规定请求方式为GET
    public Collection<Student> findAll(HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        return studentRepository.findAll();
    }


    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") int id, HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        return studentRepository.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student){
        studentRepository.saveOrUpdate(student);
    }

    @PostMapping("/update")
    public void update(@RequestBody Student student){
        studentRepository.saveOrUpdate(student);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") int id){
        studentRepository.deleteById(id);
    }
}
