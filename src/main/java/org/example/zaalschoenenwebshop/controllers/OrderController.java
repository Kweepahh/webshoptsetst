package org.example.zaalschoenenwebshop.controllers;

import org.example.zaalschoenenwebshop.dao.OrderDAO;
import org.example.zaalschoenenwebshop.dto.OrderDTO;
import org.example.zaalschoenenwebshop.dto.OrderItemDTO;
import org.example.zaalschoenenwebshop.dto.OrderResponse;
import org.example.zaalschoenenwebshop.models.Order;
import org.example.zaalschoenenwebshop.models.OrderItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/orders")
public class OrderController {

    private final OrderDAO orderDAO;

    public OrderController(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {

        List<OrderDTO> orders = orderDAO.getAllOrders()
                .stream()
                .map(this::toDTO)
                .toList();

        return ResponseEntity.ok(orders);
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderDTO dto) {
        orderDAO.createOrder(dto);

        OrderResponse response = new OrderResponse("Order created", "success");

        return ResponseEntity.ok(response);
    }

    private OrderDTO toDTO(Order order) {

        List<OrderItemDTO> items = order.getOrderItems()
                .stream()
                .map(this::toItemDTO)
                .toList();

        return new OrderDTO(
                order.getId(),
                order.getOrderDate(),
                order.getUser().getId(),
                order.getTotalPrice(),
                items,
                order.getOrderAdress()
        );
    }

    private OrderItemDTO toItemDTO(OrderItem item) {

        return new OrderItemDTO(
                item.getOrderItemId(),
                item.getOrder().getId(),
                item.getProduct().getName(),
                item.getQuantity(),
                item.getPrice()
        );
    }
}