package com.mycom.springbootjpabasiccrudfind_pm.Phone.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDto {
    private int id;
    private String company;
    private String model;
    private int gb;
    private int stock;
    private int price;
}