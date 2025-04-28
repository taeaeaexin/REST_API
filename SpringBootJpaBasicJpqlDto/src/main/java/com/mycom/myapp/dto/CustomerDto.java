package com.mycom.myapp.dto;

import com.mycom.myapp.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
@AllArgsConstructor // jpql 에서 사용할 예정
public class CustomerDto {
    private int id;
    private String name;
    private char gender;
    private String phone;
    private List<Orders> orders;
}
