package com.mycom.myapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String phone;
}