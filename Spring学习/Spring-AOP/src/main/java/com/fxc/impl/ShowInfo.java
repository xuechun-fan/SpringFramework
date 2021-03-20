package com.fxc.impl;

import com.fxc.utils.Show;
import org.springframework.stereotype.Component;

@Component
public class ShowInfo implements Show {
    public int show(int a, int b){
        System.out.println("这是测试信息。。。" + a +"-->"+ b);
        return a*2 + b*3;
    }
}
