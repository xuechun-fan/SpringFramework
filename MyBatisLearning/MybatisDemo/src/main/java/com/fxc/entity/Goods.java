package com.fxc.entity;

import lombok.Data;

import java.util.List;

@Data
public class Goods {
    private int id;
    private String name;
    private List<Customer> customers;
}
