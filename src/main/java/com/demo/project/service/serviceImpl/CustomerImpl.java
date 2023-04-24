package com.demo.project.service.serviceImpl;

import com.demo.project.dto.CustomerDto;
import com.demo.project.entities.Customer;
import com.demo.project.repository.CustomerRepository;
import com.demo.project.securityConfig.JwtGenerator;
import com.demo.project.service.CustomerService;
import com.demo.project.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerImpl implements CustomerService {
        @Autowired
        CustomerRepository customerRepo;
        @Autowired
        EmailService emailService;
        @Autowired
    PasswordEncoder passwordEncoder;
        @Autowired
        JwtGenerator jwtService;

        public String createCustomer(CustomerDto customerDto) {
            Customer customer=new Customer();
            customer.setEmail(customerDto.getEmail());
            customer.setContact(customerDto.getPhonenumber());
            if (!customerDto.getPassword().equals(customerDto.getConfirmPassword())){
                return "Password and Confirm Password doesn't match";
            }

            customer.setPassword(customerDto.getPassword());
            customer.setFirstName(customerDto.getFirstName());
            customer.setLastName(customerDto.getLastName());
            customerRepo.save(customer);
            emailService.sendMail(customer.getEmail(),jwtService.generateToken(customer.getEmail()));
            return "Customer Added Successfully";
        }
    }

