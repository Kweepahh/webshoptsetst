package org.example.zaalschoenenwebshop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {

    @JsonProperty("order_id")
    public long id;

    @JsonProperty("order_date")
    public LocalDateTime orderDate;

    @JsonProperty("user_id")
    public Long userId;

    @JsonProperty("order_price")
    public Double orderPrice;

    public List<OrderItemDTO> items;

    public OrderDTO(long id, LocalDateTime orderDate, Long userId, Double orderPrice, List<OrderItemDTO> items) {
        this.id = id;
        this.orderDate = orderDate;
        this.userId = userId;
        this.orderPrice = orderPrice;
        this.items = items;
    }
}