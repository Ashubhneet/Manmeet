package com.demo.project.controller;

import com.demo.project.dto.CustomerDto;
import com.demo.project.service.serviceImpl.CustomerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerImpl customerServiceImpl;

    @PostMapping("/register")
    public String registerCustomer(@Valid @RequestBody CustomerDto customerDto) {
        return customerServiceImpl.createCustomer(customerDto);
    }
}