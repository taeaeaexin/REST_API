package com.mycom.myapp.dto;

import com.mycom.myapp.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor // jpql 에서 사용할 예정
public class ProductDto {
    private int id;
    private String name;
    private int price;
    private int quantity;
    private String country;
    private List<Orders> orders;
}