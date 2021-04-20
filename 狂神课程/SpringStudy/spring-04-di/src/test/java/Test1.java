import com.fxc.pojo.Student;
import com.fxc.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description：
 */
public class Test1 {
    @Test
    public void testDI(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student)context.getBean("student");
        System.out.println(student.toString());
    }

    @Test
    public void testPNameSpace(){
        ApplicationContext context = new ClassPathXmlApplicationContext("testnamespace.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }

    @Test
    public void testCNameSpace(){
        ApplicationContext context = new ClassPathXmlApplicationContext("testnamespace.xml");
        User user = context.getBean("user2", User.class);
        System.out.println(user);
    }

    @Test
    public void testSingleton(){
        ApplicationContext context = new ClassPathXmlApplicationContext("testBeanScope.xml");

        //  单例模式
        User instance1 = context.getBean("instanceSingleton", User.class);
        User instance2 = context.getBean("instanceSingleton", User.class);
        System.out.println(instance2==instance1);

        System.out.println("***************************************");

        //  ProtoType模式
        instance1 = context.getBean("instancePrototype", User.class);
        instance2 = context.getBean("instancePrototype", User.class);
        System.out.println(instance2==instance1);

    }
}
