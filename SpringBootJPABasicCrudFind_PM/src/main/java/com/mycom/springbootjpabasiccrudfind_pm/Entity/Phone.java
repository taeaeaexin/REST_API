package com.mycom.springbootjpabasiccrudfind_pm.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="phone")
public class Phone {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String company;
    private String model;
    private int price;
}