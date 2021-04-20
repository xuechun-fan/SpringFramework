import com.fxc.dao.UserDaoMysqlImpl;
import com.fxc.dao.UserDaoOracleImpl;
import com.fxc.service.UserService;
import com.fxc.service.UserServiceImpl;

/**
 * Description：
 */
public class MyTest {
    public static void main(String[] args) {
        //  用户实际调用的是业务层，dao层他们不需要接触
        UserService userService = new UserServiceImpl();
        userService.setUserDao(new UserDaoMysqlImpl());
        userService.getUser();
    }
}
