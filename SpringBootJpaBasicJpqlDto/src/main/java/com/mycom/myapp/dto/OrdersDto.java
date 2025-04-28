package com.mycom.myapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor // @Builder 가 일부 파라미터를 가지는 생성자가 있으면 이걸 필요로 한다. // jpql 에서 사용할 예정
public class OrdersDto {

    private int id;
    private CustomerDto customerDto;
    private ProductDto productDto;
    private int orderQuantity;
    private LocalDate orderDate;
}