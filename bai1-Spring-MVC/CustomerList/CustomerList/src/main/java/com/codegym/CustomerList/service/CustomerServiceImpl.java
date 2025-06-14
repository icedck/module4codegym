package com.codegym.CustomerList.service;

import com.codegym.CustomerList.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {
    private static Map<Long, Customer> customers = new HashMap<>();

    static {
        customers.put(1L, new Customer(1L, "Nguyen Van A", "a@gmail.com", "HN"));
        customers.put(2L, new Customer(2L, "Le Thi B", "b@gmail.com", "HCM"));
        customers.put(3L, new Customer(3L, "Tran Van C", "c@gmail.com", "DN"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer findById(Long id) {
        return customers.get(id);
    }
}
