package com.codegym.service;

import com.codegym.model.Customer;

public interface ICustomerService extends IGenerateService<Customer> {
    boolean saveWithStoredProcedure(Customer customer);
}
