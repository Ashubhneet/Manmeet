package com.demo.project.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Category_id")
    @SequenceGenerator(name = "Category_id",sequenceName = "Categoryid",initialValue = 1,allocationSize = 1)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name="parent_id")
    private  Category category;
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<Product> productList1;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private Set<CategoryMetadataValues> categoryMetadataValues;

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

    public Category getCategory() {
        return  category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Product> getProductList1() {
        return productList1;
    }

    public void setProductList1(List<Product> productList1) {
        this.productList1 = productList1;
    }

    public Set<CategoryMetadataValues> getCategoryMetadataValues() {
        return categoryMetadataValues;
    }

    public void setCategoryMetadataValues(Set<CategoryMetadataValues> categoryMetadataValues) {
        this.categoryMetadataValues = categoryMetadataValues;
    }
}

