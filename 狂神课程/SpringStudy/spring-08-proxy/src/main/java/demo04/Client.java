package demo04;

import demo02.UserService;
import demo02.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
        //  真实角色
        UserService userService = new UserServiceImpl();

        //  代理角色
        ProxyInvocationHandler handler = new ProxyInvocationHandler();
        //  设置要代理的对象
        handler.setTarget(userService);
        //  动态生成代理类
        UserService proxy = (UserService) handler.getProxy();
        proxy.delete();
        proxy.add();
    }
}