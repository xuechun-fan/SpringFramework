package com.fxc.controller;

import com.fxc.entities.User;
import com.fxc.entities.UserList;
import com.fxc.entities.UserMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * Description：
 */

@RestController //  表示该控制器会直接将业务方法的返回值响应给客户端，不进行视图解析。
@RequestMapping("/data")
public class DataBindHandler {

    //  基本类型：如果浏览器没有给参数值，则服务器内部则会抛出异常，原因在于浏览器没有参数，服务器则会给id
    //  赋值null，而基本数据类型无法接受null值，因此抛出异常
    @RequestMapping("/baseType")
    public String baseType(int id){
        return id+"";
    }

    //  使用包装类来解决该问题
    @RequestMapping("/wrapType")
    public String wrapType(@RequestParam(value = "num", required = false, defaultValue = "100") Integer id){
        return id+"";
    }

    @RequestMapping("/array")
    public String array(String[] name){
        String str = Arrays.toString(name);
        return str;
    }

    @RequestMapping("/list")
    public String list(UserList userList){
        StringBuffer str = new StringBuffer();
        for(User user : userList.getUsers()){
            str.append(user);
        }
        return str.toString();
    }

    @RequestMapping("/map")
    public String map(UserMap usermap){
        StringBuffer str = new StringBuffer();
        for(String key : usermap.getUserMap().keySet()){
            User user = usermap.getUserMap().get(key);
            str.append(user);
        }
        return str.toString();
    }

    @RequestMapping(value = "/json")
    public User json(@RequestBody User user){
        System.out.println(user);
        user.setId(213);
        user.setName("我是菜鸡");
        return user;
    }

}
