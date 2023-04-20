package com.demo.project.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_id")
    @SequenceGenerator(name = "user_id",sequenceName = "userid",initialValue = 1,allocationSize = 1)
    private Long id;
    private long amountPaid;
    @Temporal(TemporalType.DATE)
    private LocalDate dateCreated;
    private String payementMethod;
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private Set<OrderProduct> orderproduct;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(long amountPaid) {
        this.amountPaid = amountPaid;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getPayementMethod() {
        return payementMethod;
    }

    public void setPayementMethod(String payementMethod) {
        this.payementMethod = payementMethod;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer consumer) {
        this.customer =customer;
    }
}
