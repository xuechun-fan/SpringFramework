import com.fxc.mapper.EmpMapper;
import com.fxc.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {
    @Test
    public void test(){
        //  加载MyBatis配置文件
        String resources = "mybatis-config.xml";
        InputStream in = null;
        SqlSession sqlSession = null;
        try {
            in = Resources.getResourceAsStream(resources);

            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
            sqlSession = sessionFactory.openSession(true);

            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            List<Emp> empList = mapper.selectEmp();
            for (Emp emp:empList){
                System.out.println(emp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmpMapper mapper = (EmpMapper) context.getBean("empMapper2");
        List<Emp> emps = mapper.selectEmp();
        for(Emp emp:emps){
            System.out.println(emp);
        }
    }
}