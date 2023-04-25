package com.demo.project.controller;

import com.demo.project.dto.AuthResponseDto;
import com.demo.project.dto.LoginDto;
import com.demo.project.securityConfig.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class LoginController {
    @Autowired
    JwtGenerator jwtGenerator;
    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/customer/login")
    public ResponseEntity<AuthResponseDto> customerLogin(@jakarta.validation.Valid @RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(loginDto.getEmail());
        return new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.OK);
    }

    @PostMapping("/seller/login")
    public ResponseEntity<AuthResponseDto> sellerLogin(@Valid @RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(loginDto.getEmail());
        return new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.OK);
    }
}
