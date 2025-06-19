package com.codegym.customer_management.service;

import com.codegym.customer_management.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAllCustomers();

    void saveCustomer(Customer customer);

    Customer findById(int id);

    void updateCustomer(int id, Customer customer);

    void deleteCustomer(int id);
}
