package com.demo.project.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name="USER_Id")
public class Customer extends User {
    int contact;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<Orders>orders;
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

