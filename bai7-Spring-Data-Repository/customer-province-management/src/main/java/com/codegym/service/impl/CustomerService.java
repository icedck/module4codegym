package com.codegym.service.impl;

import com.codegym.exception.DuplicateEmailException;
import com.codegym.model.Customer;
import com.codegym.model.Province;
import com.codegym.repository.ICustomerRepository;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Iterable<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer customer) throws DuplicateEmailException {
        try {
            iCustomerRepository.save(customer);
        }  catch (DataIntegrityViolationException e) {
            throw new DuplicateEmailException();
        }
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public Iterable<Customer> findAllByProvince(Province province) {
        return iCustomerRepository.findAllByProvince(province);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllByName(Pageable pageable, String name) {
        return iCustomerRepository.findAllByFirstNameContaining(pageable, name);
    }

    @Override
    public Customer findOne(Long id) throws Exception {
        Customer customer = new Customer();
        if (customer.getLastName() == null) {
            throw new Exception("customer not found!");
        }
        return customer;
    }
}