package com.demo.project.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name="USER_ID")
public class Seller extends User {
@Column(unique = true)
    String GST;
    int companyContact;
    String companyName;
    @OneToMany
    private List<Product> productList;

    public String getGST() {
        return GST;
    }

    public void setGST(String GST) {
        this.GST = GST;
    }

    public int getCompanyContact() {
        return companyContact;
    }

    public void setCompanyContact(int companyContact) {
        this.companyContact = companyContact;
    }

    public String getCompanyName() {
        return companyName;
    }

    public List<Product> getProductList() {
       return productList;
    }

    public void setProductList(List<Product> productList) {
       this.productList = productList;
   }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}
