package com.fxc.entities;

import lombok.Data;

/**
 * Description：
 */
@Data
public class User {
    private long id;
    private String name;
    private Address address;
}
