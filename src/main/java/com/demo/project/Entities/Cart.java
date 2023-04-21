package com.demo.project.Entities;

import jakarta.persistence.*;

@Entity
public class Cart {
    @EmbeddedId
    private CartId cartId;

    @ManyToOne
    @MapsId("customer")
    private Customer customer;

    @ManyToOne
    @MapsId("productVariation")
    private ProductVariation productVariation;

    private int quantity;
    @Column(name = "isWishliistItem",nullable = false )
    private boolean isWishlistItem;



}
