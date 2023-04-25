package com.demo.project.controller;

import com.demo.project.dto.CustomerDto;
import com.demo.project.repository.CustomerRepository;
import com.demo.project.service.CustomerService;
import com.demo.project.service.serviceImpl.CustomerImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerImpl customerServiceImpl;

    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@Valid @RequestBody CustomerDto customerDto) {

          return customerServiceImpl.createCustomer(customerDto);
    }
    @PutMapping("/activation")
    public ResponseEntity<?> activate(@RequestParam("token") String token) throws Exception{
        return customerServiceImpl.activationCustomer(token);
    }
}