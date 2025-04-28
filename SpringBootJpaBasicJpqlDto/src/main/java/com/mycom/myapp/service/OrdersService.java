package com.mycom.myapp.service;

import com.mycom.myapp.dto.OrdersCustomerDto;
import com.mycom.myapp.dto.OrdersDto;
import com.mycom.myapp.entity.Orders;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersService {
    // #0, #1
    List<Orders> listOrder();

    // #2
    List<OrdersDto> listOrderServiceDto();

    // #3
    List<OrdersDto> listOrdersRepositoryDto();

    // #4
    List<OrdersCustomerDto> listOrdersCustomerRepositoryDto();
}
