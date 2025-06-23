package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

//    @GetMapping("")
//    public String index(Model model) {
//        List<Customer> customers = customerService.findAll();
//        model.addAttribute("customers", customers);
//        return "index";
//    }
//
//    @GetMapping("/create")
//    public String create(Model model) {
//        model.addAttribute("customer", new Customer());
//        return "create";
//    }
//
//    @PostMapping("/save")
//    public String save(@ModelAttribute("customer") Customer customer) {
//        customerService.save(customer);
//        return "redirect:/customers";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String update(@PathVariable Long id, Model model) {
//        model.addAttribute("customer", customerService.findById(id));
//        return "update";
//    }
//
//    @PostMapping("/update")
//    public String update(@ModelAttribute("customer") Customer customer) {
//        customerService.save(customer);
//        return "redirect:/customers";
//    }
//
//    @GetMapping("/{id}/delete")
//    public String delete(@PathVariable Long id, Model model) {
//        model.addAttribute("customer", customerService.findById(id));
//        return "delete";
//    }
//
//    @PostMapping("/delete")
//    public String delete(@ModelAttribute("customer") Customer customer) {
//        customerService.remove(customer.getId());
//        return "redirect:/customers";
//    }
//
//    @GetMapping("/{id}/view")
//    public String view(@PathVariable Long id, Model model) {
//        model.addAttribute("customer", customerService.findById(id));
//        return "view";
//    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createCustomer(@ModelAttribute("customer") Customer customer) {
        boolean checkSave = customerService.saveWithStoredProcedure(customer);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("customer", new Customer());
        if (checkSave) {
            modelAndView.addObject("message", "New customer created successfully");
        }else {
            modelAndView.addObject("message", "Error exists!");
        }
        return modelAndView;
    }
}
