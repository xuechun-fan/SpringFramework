import com.fxc.pojo.People;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description：
 */
public class MyTest {

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        People people = context.getBean("people", People.class);
        System.out.println(people.getName());
        people.getDog().shout();
        people.getCat().shout();
    }

    @Test
    public void testAutowired(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        People peopleAutowired = context.getBean("peopleAutowiredByName", People.class);
        System.out.println(peopleAutowired.getName());
        peopleAutowired.getDog().shout();
        peopleAutowired.getCat().shout();

        System.out.println("******************");

        peopleAutowired = context.getBean("peopleAutowiredByType", People.class);
        System.out.println(peopleAutowired.getName());
        peopleAutowired.getDog().shout();
        peopleAutowired.getCat().shout();
    }

    @Test
    public void testAnnotationAutowired(){
        ApplicationContext context = new ClassPathXmlApplicationContext("annotationBeans.xml");
        People people = context.getBean("people", People.class);
        System.out.println(people.getName());
        people.getCat().shout();
        people.getDog().shout();
    }
}
