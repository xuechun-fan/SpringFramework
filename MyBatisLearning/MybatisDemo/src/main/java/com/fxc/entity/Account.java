package com.fxc.entity;

import com.sun.org.apache.xml.internal.serialize.LineSeparator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account{
    private Integer id;
    private String username;
    private String password;
    private int age;
    private List<Integer> ids;
}
