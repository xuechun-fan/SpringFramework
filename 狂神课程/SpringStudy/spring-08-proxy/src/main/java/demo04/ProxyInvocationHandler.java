package demo04;

import demo03.Rent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//  等会用这个类，自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {
    //  被代理的接口
    private Object target;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void setTarget(Object target) {
        this.target = target;
    }

    //  生成得到代理类
    public Object getProxy(){
        return Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this
        );
    }

    //  处理代理实例，并返回代理实例
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        log(method.getName());
        //  动态代理的本质就是使用反射机制实现
        Object invoke = method.invoke(target, args);

        return invoke;
    }

    //  日志方法
    public void log(String msg){
        SimpleDateFormat format = new SimpleDateFormat();
        System.out.println("【Debug】:" + sdf.format(new Date()) + " 执行了" + msg + "方法");
    }

}