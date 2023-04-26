package com.demo.project.service.serviceImpl;

import com.demo.project.dto.CustomerDto;
import com.demo.project.entities.Customer;
import com.demo.project.repository.CustomerRepository;
import com.demo.project.securityConfig.JwtGenerator;
import com.demo.project.service.CustomerService;
import com.demo.project.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    String usertype = "customer";

    public ResponseEntity<?> createCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setEmail(customerDto.getEmail());
        customer.setContact(customerDto.getPhonenumber());
        if (!customerDto.getPassword().equals(customerDto.getConfirmPassword())) {
            return ResponseEntity.badRequest().body("Password and Confirm Password doesn't match");
        }
        if (customerRepo.existsByEmail(customerDto.getEmail())) {
            return new ResponseEntity<>("Email is already registered", HttpStatus.BAD_REQUEST);
        }


        customer.setPassword(passwordEncoder.encode(customerDto.getPassword()));
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customerRepo.save(customer);
        emailService.sendMail(customer.getEmail(), jwtService.generateToken(customer.getEmail()), usertype);
        return new ResponseEntity<>(customerRepo.save(customer), HttpStatus.OK);
    }

    public ResponseEntity<?> activationCustomer(String token) throws Exception{
        if(!jwtService.validateToken(token)) {
            return ResponseEntity.badRequest().body("Token is expired or invalid");

        }
        String mail = jwtService.getUserEmailFromJwt(token);
        Customer customer = customerRepo.findByEmail(mail).get();
        customer.setIs_active(true);
        customerRepo.save(customer);
        return ResponseEntity.ok("Account is activated");
        }
    }


