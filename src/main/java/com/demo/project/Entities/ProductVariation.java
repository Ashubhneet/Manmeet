package com.demo.project.Entities;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
public class ProductVariation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "product_id")
    @SequenceGenerator(name = "product_id",sequenceName = "productid",initialValue = 1,allocationSize = 1)
    private Long id;
    private int quantityAvailable;
    private long price;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private Byte[] Image_name;
    private boolean isActive;
    private String metadata;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private  Product product;
    @OneToOne(mappedBy = "productVariation",cascade = CascadeType.ALL)
    private OrderProduct orderProduct;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Byte[] getImage_name() {
        return Image_name;
    }

    public void setImage_name(Byte[] image_name) {
        Image_name = image_name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}

