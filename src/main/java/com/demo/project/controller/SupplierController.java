package com.demo.project.controller;

import com.demo.project.dto.SellerDto;
import com.demo.project.repository.SellerRepository;
import com.demo.project.service.serviceImpl.SupplierImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
public class SupplierController {

    @Autowired
    SupplierImpl sellerServiceImp;

    @PostMapping("/register")
    public ResponseEntity<?> registerSeller(@Valid  @RequestBody SellerDto sellerDto){

        return sellerServiceImp.createSeller(sellerDto);
    }
}