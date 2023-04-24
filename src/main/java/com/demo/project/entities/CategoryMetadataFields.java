package com.demo.project.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class CategoryMetadataFields {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "categoryMeta_id")
    @SequenceGenerator(name = "categoryMetaid",sequenceName = "categoryMeta_id",initialValue = 1,allocationSize = 1)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "categoryMetadataFields",cascade = CascadeType.ALL)
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

    public Set<CategoryMetadataValues> getCategoryMetadataValues() {
        return categoryMetadataValues;
    }

    public void setCategoryMetadataValues(Set<CategoryMetadataValues> categoryMetadataValues) {
        this.categoryMetadataValues = categoryMetadataValues;
    }
}

