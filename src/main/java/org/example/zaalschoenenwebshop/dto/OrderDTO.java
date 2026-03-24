package org.example.zaalschoenenwebshop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {

    @JsonProperty("order_id")
    public Long id;

    @JsonProperty("order_date")
    public LocalDateTime orderDate;

    @JsonProperty("user_id")
    public Long userId;

    @JsonProperty("email")
    public String email;

    @JsonProperty("order_price")
    public Double orderPrice;

    @JsonProperty("order_address")
    public String orderAddress;

    @JsonProperty("items")
    public List<OrderItemDTO> items;

    public OrderDTO() {}

    public OrderDTO(Long id, LocalDateTime orderDate, Long userId, Double orderPrice, List<OrderItemDTO> items, String orderAddress) {
        this.id = id;
        this.orderDate = orderDate;
        this.userId = userId;
        this.orderPrice = orderPrice;
        this.items = items;
        this.orderAddress = orderAddress;
    }
}