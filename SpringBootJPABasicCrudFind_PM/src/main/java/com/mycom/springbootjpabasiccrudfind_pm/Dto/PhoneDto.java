package com.mycom.springbootjpabasiccrudfind_pm.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhoneDto {
    private int id;
    private String company;
    private String model;
    private int price;

    public static PhoneDto fromEntity(com.mycom.springbootjpabasiccrudfind_pm.Entity.Phone phone) {
        return PhoneDto.builder()
                .id(phone.getId())
                .company(phone.getCompany())
                .model(phone.getModel())
                .price(phone.getPrice())
                .build();
    }
}
