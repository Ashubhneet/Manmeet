package com.demo.project.entities;

import com.demo.project.enums.Authority;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="ROLE")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "role_id")
    @SequenceGenerator(name = "role_id",sequenceName = "roleid",initialValue = 1,allocationSize = 1)

    @Column(columnDefinition = "BINARY(16)")
    private Long id;
    @Enumerated(EnumType.STRING)
    private Authority authority;
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

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

}

