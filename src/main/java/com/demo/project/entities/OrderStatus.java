package com.demo.project.entities;

import com.demo.project.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class OrderStatus {
    @Enumerated(EnumType.STRING)
    private Status fromStatus;
    @Enumerated(EnumType.STRING)
    private Status tostatus;
    private String transitionNotes;
    @Temporal(TemporalType.DATE)
    private LocalDate transitionDate;
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    private OrderProduct orderProduct;
    public Status getFromStatus() {
        return fromStatus;
    }

    public void setFromStatus(Status fromStatus) {
        this.fromStatus = fromStatus;
    }

    public Status getTostatus() {
        return tostatus;
    }

    public void setTostatus(Status tostatus) {
        this.tostatus = tostatus;
    }

    public String getTransitionNotes() {
        return transitionNotes;
    }

    public void setTransitionNotes(String transitionNotes) {
        this.transitionNotes = transitionNotes;
    }

    public LocalDate getTransitionDate() {
        return transitionDate;
    }

    public void setTransitionDate(LocalDate transitionDate) {
        this.transitionDate = transitionDate;
    }

    public OrderProduct getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(OrderProduct orderProduct) {
        this.orderProduct = orderProduct;
    }

}
