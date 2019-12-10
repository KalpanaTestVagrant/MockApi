package com.rapido.dbservice.dbservice.dao;

import com.rapido.dbservice.dbservice.models.order.Order;
import com.rapido.dbservice.dbservice.queries.OrderQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

public class OrderDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private OrderQueries orderQueries;

    public OrderDao(MongoTemplate mongoTemplate, OrderQueries orderQueries) {
        this.mongoTemplate = mongoTemplate;
        this.orderQueries = orderQueries;
    }

    public Order findOrderByRequestId(String requestId) {
        Order order = mongoTemplate.findOne(orderQueries.findByRequestId(requestId), Order.class, "orders");
        return order;
    }

    public Order findOrderByOrderId(String orderId) {
        Order order = mongoTemplate.findOne(orderQueries.findByOrderId(orderId), Order.class, "orders");
        return order;
    }

    public List<Order> findOrderByStatus(String status) {
        List<Order> orders = mongoTemplate.find(orderQueries.findByStatus(status), Order.class, "orders");
        return orders;
    }

    public List<Order> findOrderByRequestIdAndStatus(String requestId, String status) {
        List<Order> orders = mongoTemplate.find(orderQueries.findByRequestIdAndStatus(requestId, status), Order.class, "orders");
        return orders;
    }
}
