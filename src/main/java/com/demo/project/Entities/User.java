package com.demo.project.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;
@Entity
@Table(name="USER")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_id")
    @SequenceGenerator(name = "user_id",sequenceName = "userid",initialValue = 1,allocationSize = 1)
    private Long id;

    @Column(unique = true)
    private String email;
    private String first_name;
    private String last_name;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,15}$",
            message = "password must be min 4 and max 12 length containing atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
    private String password;
    @Column(name = "is_delete", nullable = false)
    private boolean is_deleted=Boolean.FALSE;
    @Column(name = "is_active")
    private boolean is_active;
    @Column(name = "is_expired", nullable = false)
    private boolean is_expired;
    @Column(name = "is_locked", nullable = false)
    private boolean is_locked;
    @Column(name = "invalid_attempt_count",precision = 0)
    private int invalid_attempt_count;
    @Temporal(TemporalType.DATE)
    private LocalDate password_update_date;
    @ManyToMany(mappedBy = "user",cascade=CascadeType.ALL)
//    @JoinTable(name = "USER_ROLE",joinColumns = @JoinColumn(name="User_ID",referencedColumnName = "UUID")
//            , inverseJoinColumns = @JoinColumn(name="ROLE_ID",referencedColumnName = "UUID"))
    private Set<Role> role;
    @OneToMany(mappedBy = "user",cascade =CascadeType.ALL)
    private List<Address>address;
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public boolean isIs_expired() {
        return is_expired;
    }

    public void setIs_expired(boolean is_expired) {
        this.is_expired = is_expired;
    }

    public boolean isIs_locked() {
        return is_locked;
    }

    public void setIs_locked(boolean is_locked) {
        this.is_locked = is_locked;
    }

    public int getInvalid_attempt_count() {
        return invalid_attempt_count;
    }

    public void setInvalid_attempt_count(int invalid_attempt_count) {
        this.invalid_attempt_count = invalid_attempt_count;
    }

    public LocalDate getPassword_update_date() {
        return password_update_date;
    }

    public void setPassword_update_date(LocalDate password_update_date) {
        this.password_update_date = password_update_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }
}

