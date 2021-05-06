package com.fxc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Controller
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //  查询数据库的所有信息
    //  没有实体类，数据库中的东西，怎么获取？ Map
    @ResponseBody
    @GetMapping("/userList")
    public List<Map<String, Object>> userList(){
        String sql = "select * from mydb.t_emp";
        List<Map<String, Object>> list_maps = jdbcTemplate.queryForList(sql);
        return list_maps;
    }

    @GetMapping("/addUser")
    public String addUser(){
        String sql = "insert into mydb.t_emp values (11, '周杰伦', 40, 3, 100021)";
        jdbcTemplate.update(sql);
        return "redirect:/userList";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") Integer id){
        String sql = "update mydb.t_emp set name=? where id=" + id;
        //  封装
        Object object = "小明";
        jdbcTemplate.update(sql, object);
        return "redirect:/userList";
    }


    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id")Integer id){
        String sql = "delete from mydb.t_emp where id="+id;
        jdbcTemplate.execute(sql);
        return "redirect:/userList";
    }

}