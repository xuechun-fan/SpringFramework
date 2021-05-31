package com.fxc.service;

import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    //  告诉Spring这是一个异步方法
    public void hello(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据正在处理");
    }
}