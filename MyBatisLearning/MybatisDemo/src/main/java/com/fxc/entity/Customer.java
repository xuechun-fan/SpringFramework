package com.fxc.entity;

import lombok.Data;

import java.util.List;

@Data
public class Customer {
    private int id;
    private String name;
    private List<Goods> goods;
}
