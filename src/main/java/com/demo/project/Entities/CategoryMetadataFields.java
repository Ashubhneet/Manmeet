package com.demo.project.Entities;

import jakarta.persistence.*;

import java.util.UUID;
@Entity
@Table(name="categoryMetadata")
public class CategoryMetadataFields {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "category_id")
    @SequenceGenerator(name = "categoryid",sequenceName = "category_id",initialValue = 1,allocationSize = 1)
    private Long id;
    private String name;

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
}
