package com.fxc.repository;

import com.fxc.entity.Customer;

public interface CustomerRepository {
    public Customer findById(int id);
}
