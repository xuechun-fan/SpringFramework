package com.fxc.repository;

import com.fxc.entity.Account;
import com.sun.org.apache.xml.internal.serialize.LineSeparator;

import java.util.List;

public interface AccountRepository {
    public int save(Account account);
    public int update(Account account);
    public int delete(int id);
    public List<Account> findAll();
    public Account findById(int id);
    public Account findByName(String username);
    public Account findByNameAndAge(String name, int age);
    public int count();
    public String findNameById(int id);
    public Account findByAccount(Account account);
    public List<Account> findByIds(Account account);
}
