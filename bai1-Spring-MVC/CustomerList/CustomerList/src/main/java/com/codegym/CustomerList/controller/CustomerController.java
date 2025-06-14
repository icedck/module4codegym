package com.codegym.CustomerList.controller;

import com.codegym.CustomerList.model.Customer;
import com.codegym.CustomerList.service.CustomerService;
import com.codegym.CustomerList.service.CustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;


@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService = new CustomerServiceImpl();

    @GetMapping
    public String showList(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "customers/list";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable Long id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "customers/view";
    }
}