package com.demo.project.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;
@Entity
@Table(name="ROLE")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "role_id")
    @SequenceGenerator(name = "role_id",sequenceName = "roleid",initialValue = 1,allocationSize = 1)

    @Column(columnDefinition = "BINARY(16)")
    private Long id;
    private String authority;
    @ManyToMany()
    private Set<User> user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

}

