package com.codegym.CustomerList.service;

import com.codegym.CustomerList.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(Long id);
}
