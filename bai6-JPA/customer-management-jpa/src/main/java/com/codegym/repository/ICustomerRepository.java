package com.codegym.repository;

import com.codegym.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends IGenerateRepository<Customer> {
    boolean saveWithStoredProcedure(Customer customer);
}
