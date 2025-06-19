package com.codegym.customer_management.service;

import com.codegym.customer_management.model.Customer;
import com.codegym.customer_management.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;

//    private static final Map<Integer, Customer> customers;
//
//    static {
//        customers = new HashMap<>();
//        customers.put(1, new Customer(1, "John", "john@codegym.vn", "Ha Noi"));
//        customers.put(2, new Customer(2, "Bill", "bill@codegym.vn", "Hai Phong"));
//        customers.put(3, new Customer(3, "Alex", "alex@codegym.vn", "Sai Gon"));
//        customers.put(4, new Customer(4, "Adam", "adam@codegym.vn", "Beijing"));
//        customers.put(5, new Customer(5, "Sophia", "sophia@codegym.vn", "Miami"));
//        customers.put(6, new Customer(6, "Rose", "rose@codegym.vn", "NewYork"));
//    }
//
//    @Override
//    public void deleteCustomer(int id) {
//        customers.remove(id);
//    }
//
//    @Override
//    public void updateCustomer(int id, Customer customer) {
//        customers.put(id, customer);
//    }
//
//    @Override
//    public Customer findById(int id) {
//        return customers.get(id);
//    }
//
//    @Override
//    public void saveCustomer(Customer customer) {
//        customers.put(customer.getId(), customer);
//    }
//
//    @Override
//    public List<Customer> findAllCustomers() {
//        return new ArrayList<>(customers.values());
//    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void updateCustomer(int id, Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }
}
