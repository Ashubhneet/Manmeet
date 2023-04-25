package com.demo.project.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
//@PrimaryKeyJoinColumn(name="USER_Id")
public class Customer extends User {
    String contact;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<Orders>orders;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<ProductReview> productReviewSet;

    @ManyToOne
   // @JoinColumn(name="Address_id")
    private Address add;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private Set<Cart> cart;

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<Orders> getOrders() {
        return orders;
    }
    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public Set<ProductReview> getProductReviewSet() {
        return productReviewSet;
    }

    public void setProductReviewSet(Set<ProductReview> productReviewSet) {
        this.productReviewSet = productReviewSet;
    }

    public Address getAdd() {
        return add;
    }

    public void setAdd(Address add) {
        this.add = add;
    }

    public Set<Cart> getCart() {
        return cart;
    }

    public void setCart(Set<Cart> cart) {
        this.cart = cart;
    }


}

