import com.fxc.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description：
 */
public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user = (User)context.getBean("user");
        System.out.println(user.getName());

        System.out.println("--------------------------");

        User user1 = (User)context.getBean("user1");
        System.out.println(user1.getName());

        System.out.println("--------------------------");

        User user2 = (User)context.getBean("user2");
        System.out.println(user2.getName());

        System.out.println("--------------------------");

        User user3 = (User)context.getBean("user3");
        System.out.println(user3.getName());

    }
}
