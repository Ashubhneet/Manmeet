package com.demo.project.repository;

import com.demo.project.entities.Seller;
import org.springframework.data.repository.CrudRepository;

public interface SellerRepository extends CrudRepository<Seller,Long> {
    Seller findByEmailIgnoreCase(String email);
    Boolean existsByEmail(String Email);
}
