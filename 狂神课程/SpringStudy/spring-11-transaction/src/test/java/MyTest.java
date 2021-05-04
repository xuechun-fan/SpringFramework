import com.fxc.mapper.EmpMapper;
import com.fxc.pojo.Emp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmpMapper mapper = context.getBean("empMapper", EmpMapper.class);
        List<Emp> emps = mapper.selectEmp();
        for (Emp emp:emps){
            System.out.println(emp);
        }
    }
}