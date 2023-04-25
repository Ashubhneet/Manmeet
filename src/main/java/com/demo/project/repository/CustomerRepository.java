package com.demo.project.repository;
import com.demo.project.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Boolean existsByEmail(String Email);


    Optional<Customer> findByEmail(String mail);
}
