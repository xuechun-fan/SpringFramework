package com.fxc.impl;

import com.fxc.utils.Cal;
import org.springframework.stereotype.Component;

@Component
public class CalImpl implements Cal {
    public int add(int m, int n) {
        int res = m+n;
        return res;
    }

    public int sub(int m, int n) {
        int res = m-n;
        return res;
    }

    public int mul(int m, int n) {
        int res = m*n;
        return res;
    }

    public int div(int m, int n) {
        int res = m/n;
        return res;
    }
}
