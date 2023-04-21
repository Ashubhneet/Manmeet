package com.demo.project.Entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "product_id")
    @SequenceGenerator(name = "product_id",sequenceName = "productid",initialValue = 1,allocationSize = 1)
    private Long id;
    private String name;
    private String description;
    @Column(name = "isCancellable", nullable = false)
    private boolean isCancellable;
    @Column(name = "isReturnable", nullable = false)
    private boolean isReturnable;

    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @Column(name = "isDeleted", nullable = false)
    private boolean isDeleted;
    private String brand;
    @ManyToOne
//    @JoinColumn(name="USER_ID")
    private Seller seller;

    @ManyToOne
    @JoinColumn(name="categoriesid")
    private Category category;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<ProductVariation> productVariationList;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private Set<ProductReview> productReview;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCancellable() {
        return isCancellable;
    }

    public void setCancellable(boolean cancellable) {
        isCancellable = cancellable;
    }

    public boolean isReturnable() {
        return isReturnable;
    }

    public void setReturnable(boolean returnable) {
        isReturnable = returnable;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<ProductVariation> getProductVariationList() {
        return productVariationList;
    }

    public void setProductVariationList(List<ProductVariation> productVariationList) {
        this.productVariationList = productVariationList;
    }
}

