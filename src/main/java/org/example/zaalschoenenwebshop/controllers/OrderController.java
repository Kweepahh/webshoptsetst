package org.example.zaalschoenenwebshop.controllers;


import org.example.zaalschoenenwebshop.dao.OrderDAO;
import org.example.zaalschoenenwebshop.dto.OrderDTO;
import org.example.zaalschoenenwebshop.dto.ZaalSchoenDTO;
import org.example.zaalschoenenwebshop.models.Order;
import org.example.zaalschoenenwebshop.models.ZaalSchoen;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/orders")
public class OrderController {

    private OrderDAO orderDAO;

    public OrderController(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {

        List<OrderDTO> order = orderDAO.getAllOrders()
                .stream()
                .map(this::toDTO)
                .toList();

        return ResponseEntity.ok(order);

    }


    private OrderDTO toDTO(Order order) {
        return new OrderDTO(
                order.getId(),
                order.getOrderDate(),
                order.getUser(),
                order.getTotalPrice(),
                order.getOrderItems()
        );
    }
}
