package app.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import app.services.CustomerRepository;

@Controller
public class CustomerController {
    
    @Autowired
    private CustomerRepository customers;

    @GetMapping("/login")
    public String index() {
        return "customer";
    }

    @GetMapping("/orders")
    public ModelAndView orders(Principal user) {
        var result = new ModelAndView("invoice");
        var customer = customers.findById(user.getName()).get();
        result.addObject("customer", customer);
        return result;
    }
}
