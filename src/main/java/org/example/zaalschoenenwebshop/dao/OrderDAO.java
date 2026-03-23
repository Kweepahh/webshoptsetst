package org.example.zaalschoenenwebshop.dao;

import org.example.zaalschoenenwebshop.models.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDAO {
    private OrderRepository repository;
    private OrderItemRepository orderItemRepository;

    public OrderDAO(OrderRepository repository, OrderItemRepository orderItemRepository) {
        this.repository = repository;
        this.orderItemRepository = orderItemRepository;
    }
    public List<Order> getAllOrders(){
        return this.repository.findAll();
    }
}
