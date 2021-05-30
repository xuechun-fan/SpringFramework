package com.fxc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fxc.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class RedisSpringbootApplicationTests {


    @Qualifier("redisTemplate")
    @Autowired
    private RedisTemplate template;

    @Test
    void contextLoads() {
        template.opsForValue().set("fxc", "努力学习技术");
        Object fxc = template.opsForValue().get("fxc");
        System.out.println(fxc);
    }

    @Test
    public void test() throws JsonProcessingException {
        //  真实的开发一般都是用json来传递对象
        User user = new User("范学春", 23);
//        String jsonUser = new ObjectMapper().writeValueAsString(user);
//        template.opsForValue().set("user", jsonUser);
        template.opsForValue().set("user", user);
        System.out.println(template.opsForValue().get("user"));
    }

}
