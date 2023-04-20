package com.demo.project.Entities;

import jakarta.persistence.*;
@Entity
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_id")
    @SequenceGenerator(name = "user_id",sequenceName = "userid",initialValue = 1,allocationSize = 1)
    private Long id;
    private int quantity;
    private long price;
    @ManyToOne
    @JoinColumn(name="order_id")
    private Orders order;

    @OneToOne(cascade = CascadeType.ALL)
    private ProductVariation productVariation;

    @OneToOne(mappedBy = "orderProduct",cascade = CascadeType.ALL)
    private OrderStatus orderStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public ProductVariation getProductVariation() {
        return productVariation;
    }

    public void setProductVariation(ProductVariation productVariation) {
        this.productVariation = productVariation;
    }
}
