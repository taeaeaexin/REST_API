package com.mycom.myapp.service;

import com.mycom.myapp.dto.OrdersCustomerDto;
import com.mycom.myapp.dto.OrdersDto;
import com.mycom.myapp.entity.Orders;
import com.mycom.myapp.repository.Ordersrepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {
    private final Ordersrepository ordersRepository;

    @Override
    public List<Orders> listOrder() {
        return ordersRepository.listOrder();
    }

    @Override
    public List<OrdersDto> listOrderServiceDto() {
        List<Orders> ordersList = ordersRepository.listOrdersServiceDto();
        List<OrdersDto> ordersDtoList = new ArrayList<>();

        ordersList.forEach(orders -> {
            OrdersDto ordersDto
                = OrdersDto.builder()
                    .id(orders.getId())
                    .orderQuantity(orders.getOrderQuantity())
                    .orderDate(orders.getOrderDate())
                    .build();
            ordersDtoList.add(ordersDto);
        });

        return ordersDtoList;
    }

    @Override
    public List<OrdersDto> listOrdersRepositoryDto() {
        return ordersRepository.listOrdersRepositoryDto();
    }

    @Override
    public List<OrdersCustomerDto> listOrdersCustomerRepositoryDto() {
        return ordersRepository.listOrdersCustomerRepositoryDto();
    }
}