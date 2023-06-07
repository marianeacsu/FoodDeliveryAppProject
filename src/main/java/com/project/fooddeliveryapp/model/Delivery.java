package com.project.fooddeliveryapp.model;

import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "delivery_id")
    private int deliveryId;
    @NotNull
    private boolean paid;
    private Date date;
    @NotNull
    private String paymentType;
    private boolean delivered;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Delivery(int deliveryId, boolean paid, Date date, String paymentType,boolean delivered ,Order order) {
        this.deliveryId = deliveryId;
        this.paid = paid;
        this.date = date;
        this.paymentType = paymentType;
        this.delivered = delivered;
        this.order = order;
    }

    public Delivery() {

    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }


    @Override
    public String toString() {
        return "Delivery{" +
                "deliveryId=" + deliveryId +
                ", paid=" + paid +
                ", date=" + date +
                ", paymentType='" + paymentType + '\'' +
                ", order=" + order +
                '}';
    }
}
