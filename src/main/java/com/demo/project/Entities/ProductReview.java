package com.demo.project.Entities;

import jakarta.persistence.*;

@Entity
public class ProductReview {
    @EmbeddedId
    private ProductReviewId productReviewId;
    @ManyToOne
    @MapsId("customer")
    private Customer customer;

    @ManyToOne
    @MapsId("product")
    private Product product;

    private String review;
    private String rating;

}
