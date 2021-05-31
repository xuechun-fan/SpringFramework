package com.fxc.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {


    //  cron表达式
    //  秒   分   时   日   月   周几
    @Scheduled(cron = "0/5 28-30 * * * ?")
    public void hello(){
        //  在特定的时间执行这个方法
        System.out.println("hello scheduler!!!");
    }
}