package com.codegym.service;

import com.codegym.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class SimpleCustomerServiceImpl implements ICustomerService {
    private final List<Customer> customers;

    public SimpleCustomerServiceImpl() {
        customers = new ArrayList<>();
        customers.add(new Customer(1L, "Nguyen Khac Nhat", "nhat@codegym.vn", "Hà Nội"));
        customers.add(new Customer(2L, "Dang Huy Hoa", "hoa.dang@codegym.vn", "Đà Nẵng"));
        customers.add(new Customer(3L, "Nguyen Thuy Duong", "duong.nguyen@codegym.vn", "Sài Gòn"));
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findById(Long id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void save(Customer customer) {
        Customer c = findById(customer.getId());
        c.setName(customer.getName());
        c.setAddress(customer.getAddress());
        c.setEmail(customer.getEmail());
    }
}
