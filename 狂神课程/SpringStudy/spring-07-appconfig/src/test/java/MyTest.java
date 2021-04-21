import com.fxc.config.UserConfig;

import com.fxc.pojo.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {

    @Test
    public void test1(){
        //如果完全使用了配置类的方式，我们就只能使用AnnotationConfigApplicationContext上下文来获取容器，通过
        //配置类的class对象来加载
        ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
        User user = (User)context.getBean("user");
        System.out.println(user.getName());
    }
}