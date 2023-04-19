package com.demo.project.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;
@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Category_id")
    @SequenceGenerator(name = "Category_id",sequenceName = "Categoryid",initialValue = 1,allocationSize = 1)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="category_id")
    private List<Category> category;
}
