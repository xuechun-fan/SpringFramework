package com.fxc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description：
 */
@Controller
@RequestMapping("/data")
public class DataBindHandler {

    //  基本类型：如果浏览器没有给参数值，则服务器内部则会抛出异常，原因在于浏览器没有参数，服务器则会给id
    //  赋值null，而基本数据类型无法接受null值，因此抛出异常
    @RequestMapping("/baseType")
    @ResponseBody
    public String baseType(int id){
        return id+"";
    }

    //  使用包装类来解决该问题
    @RequestMapping("/wrapType")
    @ResponseBody
    public String wrapType(Integer id){
        return id+"";
    }


}
