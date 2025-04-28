package com.mycom.myapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
//  @ManyToOne(fetch = FetchType.LAZY)
//  @ToString.Exclude
    private Customer customer;

    @ManyToOne
//  @ManyToOne(fetch = FetchType.LAZY)
//  @ToString.Exclude
    private Product product;


    @Column(name = "order_quantity")
    private int orderQuantity;

    @Column(name = "order_date")
    private LocalDate orderDate;
}
