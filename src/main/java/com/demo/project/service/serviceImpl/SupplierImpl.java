package com.demo.project.service.serviceImpl;

import com.demo.project.dto.SellerDto;
import com.demo.project.entities.Seller;
import com.demo.project.repository.SellerRepository;
import com.demo.project.securityConfig.JwtGenerator;
import com.demo.project.service.EmailService;
import com.demo.project.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SupplierImpl implements SupplierService {
    @Autowired
    SellerRepository sellerRepo;
    @Autowired
    EmailService emailService;
    @Autowired
    JwtGenerator jwtService;
    public String createSeller(SellerDto sellerDto) {
        Seller seller = new Seller();
        seller.setEmail(sellerDto.getEmail());
        if (!sellerDto.getPassword().equals(sellerDto.getConfirmPassword())) {
            return "Password and Confirm Password doesn't match";
        }
        seller.setPassword(sellerDto.getPassword());
        seller.setFirstName(sellerDto.getFirstName());
        seller.setLastName(sellerDto.getLastName());
        seller.setCompanyName(sellerDto.getCompanyName());
        seller.setCompanyContact(sellerDto.getCompanyContact());
        seller.setGST(sellerDto.getGst());
        sellerRepo.save(seller);
        emailService.sendMail(seller.getEmail(), jwtService.generateToken(seller.getEmail()));
        return "Seller Added Successfully";


    }
}


