package com.mycom.myapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private char gender;
    private String phone;

    @OneToMany(mappedBy = "customer")
//  @ToString.Exclude
    private List<Orders> orders;
}
