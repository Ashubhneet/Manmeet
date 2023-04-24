package com.demo.project.entities;

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

    public ProductReviewId getProductReviewId() {
        return productReviewId;
    }

    public void setProductReviewId(ProductReviewId productReviewId) {
        this.productReviewId = productReviewId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
