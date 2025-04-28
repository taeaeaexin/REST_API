package com.mycom.myapp.controller;

import com.mycom.myapp.dto.OrdersCustomerDto;
import com.mycom.myapp.dto.OrdersDto;
import com.mycom.myapp.entity.Orders;
import com.mycom.myapp.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrdersController {
    private final OrdersService ordersService;

    // #0
    // Controller에서 Entity를 JSON으로 변환, 전달
//    @GetMapping("listorders")
//    public List<Orders> listOrders(){
//        return ordersService.listOrder();
//    }

    // #1
    // Controller에서 Entity -> Dto 변경 후, Dto를 JSON 변환, 응답
//    @GetMapping("/listorders")
//    public List<OrdersDto> listOrders(){
//        List<Orders> ordersList = ordersService.listOrder();
//        List<OrdersDto> ordersDtoList = new ArrayList<>();
//        ordersList.forEach(orders -> {
//            OrdersDto ordersDto
//                    = OrdersDto.builder()
//                            .id(orders.getId())
//                            .orderQuantity(orders.getOrderQuantity())
//                            .orderDate(orders.getOrderDate())
//                            .build();
//            ordersDtoList.add(ordersDto);
//        });
//        return ordersDtoList;
//    }

    // #2
    // Service에서 Entity -> Dto 변경 후, Dto를 JSON 변환, 응답
//    @GetMapping("/listordersservicedto")
//    public List<OrdersDto> listOrders(){
//        return ordersService.listOrderServiceDto();
//    }

    // #3
//    @GetMapping("/listordersrepositorydto")
//    public List<OrdersDto> listOrders(){
//        return ordersService.listOrdersRepositoryDto();
//    }

    // #4
    @GetMapping("/listordersrepositorydto")
    public List<OrdersCustomerDto> listOrders(){
        return ordersService.listOrdersCustomerRepositoryDto();
    }
}