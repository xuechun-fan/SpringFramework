package demo02;

import javafx.scene.input.DataFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserServiceProxy implements UserService{
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void add() {
        log();
        userService.add();
    }

    public void delete() {
        log();
        userService.delete();
    }

    public void update() {
        log();
        userService.update();
    }

    public void query() {
        log();
        userService.query();
    }

    //  日志方法
    public void log(){
        SimpleDateFormat format = new SimpleDateFormat();
        System.out.println("【Debug】" + new Date());
    }
}