package com.mycom.springbootjpabasiccrudfind_pm.Phone.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="phone")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Phone {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String company;
    private String model;
    private int gb;
    private int stock;
    private int price;
}