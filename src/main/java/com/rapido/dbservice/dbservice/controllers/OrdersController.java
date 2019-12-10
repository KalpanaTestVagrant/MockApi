package com.rapido.dbservice.dbservice.controllers;

import com.rapido.dbservice.dbservice.dao.OrderDao;
import com.rapido.dbservice.dbservice.models.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class OrdersController {

    @Autowired
    OrderDao orderDao;

    public OrdersController(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @GetMapping("/orders")
    public List<Order> getOrderByRequestId(@RequestParam("requestId") String requestId, @RequestParam(value = "status", required = false) String status) {
       if(status == null) {
           Order order =  orderDao.findOrderByRequestId(requestId);
           return Arrays.asList(order);
       } else {
           return orderDao.findOrderByRequestIdAndStatus(requestId, status);
       }


    }
}
