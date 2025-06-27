package com.codegym.controller;

import com.codegym.exception.DuplicateEmailException;
import com.codegym.model.Customer;
import com.codegym.model.Province;
import com.codegym.service.ICustomerService;
import com.codegym.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/provinces")
public class ProvinceController {
    @Autowired
    private IProvinceService provinceService;

    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public ModelAndView listProvinces() {
        ModelAndView mav = new ModelAndView("/province/list");
        Iterable<Province> provinces = provinceService.findAll();
        mav.addObject("provinces", provinces);
        return mav;
    }

    @GetMapping("/create")
    public ModelAndView createProvince() {
        ModelAndView mav = new ModelAndView("/province/create");
        mav.addObject("province", new Province());
        return mav;
    }

    @PostMapping("/create")
    public String createProvince(@ModelAttribute("province") Province province, RedirectAttributes redirectAttributes) throws DuplicateEmailException {
        provinceService.save(province);
        redirectAttributes.addFlashAttribute("message", "Create new province successfully");
        return "redirect:/provinces";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateProvince(@PathVariable("id") Long id) {
        Optional<Province> province = provinceService.findById(id);
        if (province.isPresent()) {
            ModelAndView mav = new ModelAndView("/province/update");
            mav.addObject("province", province.get());
            return mav;
        }else {
            return new ModelAndView("error_404");
        }
    }

    @GetMapping("/view-province/{id}")
    public ModelAndView viewProvince(@PathVariable("id") Long id){
        Optional<Province> province = provinceService.findById(id);
        if (!province.isPresent()) {
            return new ModelAndView("error_404");
        }

        Iterable<Customer> customers= customerService.findAllByProvince(province.get());
        ModelAndView mav = new ModelAndView("/customer/list");
        mav.addObject("customers", customers);
        return mav;
    }
}
