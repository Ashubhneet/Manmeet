package com.demo.project.service.serviceImpl;

import com.demo.project.dto.SellerDto;
import com.demo.project.entities.Seller;
import com.demo.project.repository.SellerRepository;
import com.demo.project.securityConfig.JwtGenerator;
import com.demo.project.service.EmailService;
import com.demo.project.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class SupplierImpl implements SupplierService {
    @Autowired
    SellerRepository sellerRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    EmailService emailService;
    @Autowired
    JwtGenerator jwtService;
    String usertype="Supplier";
    public ResponseEntity<?> createSeller(SellerDto sellerDto) {
        Seller seller = new Seller();
        seller.setEmail(sellerDto.getEmail());
        if (!sellerDto.getPassword().equals(sellerDto.getConfirmPassword())) {
            return ResponseEntity.badRequest().body("Password and Confirm Password doesn't match");
        }
        if (sellerRepo.existsByEmail(sellerDto.getEmail())){
            return new ResponseEntity<>("Email is already registered", HttpStatus.BAD_REQUEST);
        }

        seller.setPassword(passwordEncoder.encode(sellerDto.getPassword()));
        seller.setFirstName(sellerDto.getFirstName());
        seller.setLastName(sellerDto.getLastName());
        seller.setCompanyName(sellerDto.getCompanyName());
        seller.setCompanyContact(sellerDto.getCompanyContact());
        seller.setGST(sellerDto.getGst());
        sellerRepo.save(seller);
        emailService.sendMail(seller.getEmail(), jwtService.generateToken(seller.getEmail()),usertype);
        return new ResponseEntity<>(sellerRepo.save(seller), HttpStatus.OK);


    }
}


