package com.fxc.pojo;

/**
 * Description：
 */
public class User {
    private String name;

    public User(){
        System.out.println("无参构造\tUser 类加载并初始化...");
    }

    public User(String n) {
        this.name = n;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
