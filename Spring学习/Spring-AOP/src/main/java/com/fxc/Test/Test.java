package com.fxc.Test;

import com.fxc.impl.CalImpl;
import com.fxc.utils.Cal;
import com.fxc.utils.MyInvocationHandler;

public class Test {
    public static void main(String[] args) {
        Cal cal = new CalImpl();
        MyInvocationHandler handler = new MyInvocationHandler();
        Cal proxy = (Cal)handler.bind(cal);
        proxy.add(10, 2);
        proxy.sub(10, 2);
        proxy.mul(10, 2);
        proxy.div(10, 2);
    }
}
