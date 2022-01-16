package com.fxc.shirodemo.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 生成密码
 * @author FXC  2021年12月19日 21:20
 */
public class PasswordUtils {

    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("123456", "1a2b3c4d", 1024);
        System.out.println("zhangsan md5Hash = " + md5Hash);
    }
}
