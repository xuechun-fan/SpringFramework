package com.fxc.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Description：
 */

@Data
@Scope
@Component  //  等价于配置文件中配置了bean标签
public class User {
    public String name;

    @Value("周董")
    public void setName(String name) {
        this.name = name;
    }
}
