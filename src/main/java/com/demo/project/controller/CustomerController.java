package com.demo.project.controller;

import com.demo.project.dto.AuthResponseDto;
import com.demo.project.dto.CustomerDto;
import com.demo.project.dto.LoginDto;
import com.demo.project.repository.CustomerRepository;
import com.demo.project.securityConfig.JwtGenerator;
import com.demo.project.service.CustomerService;
import com.demo.project.service.serviceImpl.CustomerImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class CustomerController {

    @Autowired
    CustomerImpl customerServiceImpl;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtGenerator jwtGenerator;
    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@Valid @RequestBody CustomerDto customerDto) {

          return customerServiceImpl.createCustomer(customerDto);
    }
    @PutMapping("/activation")
    public ResponseEntity<?> activate(@RequestParam String token) throws Exception{
        return customerServiceImpl.activationCustomer(token);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<AuthResponseDto> customerLogin(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(loginDto.getEmail());
        return new ResponseEntity<AuthResponseDto>(new AuthResponseDto(token), HttpStatus.OK);
    }

}