package com.demo.project.Entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
//@PrimaryKeyJoinColumn(name="USER_Id")
public class Customer extends User {
    int contact;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<Orders>orders;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<ProductReview> productReviewSet;

    @ManyToOne
   // @JoinColumn(name="Address_id")
    private Address add;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private Set<Cart> cart;

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    //public List<Orders> getOrders() {
      //  return orders;
    //}

   // public void setOrders(List<Orders> orders) {
        //this.orders = orders;
    //}
}

