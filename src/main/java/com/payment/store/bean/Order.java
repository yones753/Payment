package com.payment.store.bean;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;
    private double price;
    private String currency;
    private String method;
    private String intent;
    private String description;
    @ManyToOne
    @JoinColumn(name = "payment_id", nullable = true)
    private Payment payment;

}
