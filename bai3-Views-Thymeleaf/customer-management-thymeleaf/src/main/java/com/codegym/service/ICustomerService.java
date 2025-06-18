package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAllCustomers();

    void saveCustomer(Customer customer);

    Customer findById(int id);

    void updateCustomer(int id, Customer customer);

    void deleteCustomer(int id);
}
