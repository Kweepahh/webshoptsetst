package org.example.zaalschoenenwebshop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.zaalschoenenwebshop.models.CustomUser;
import org.example.zaalschoenenwebshop.models.OrderItem;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {

    @JsonProperty("order_id")
    public long id;

    @JsonProperty("order_date")
    public LocalDateTime orderDate;

    @JsonProperty("user_id")
    public CustomUser userId;

    @JsonProperty("order_price")
    public Double orderPrice;

    public List<OrderItem> items;

    public OrderDTO(long id, LocalDateTime orderDate, CustomUser userId, Double orderPrice, List<OrderItem> items) {
        this.id = id;
        this.orderDate = orderDate;
        this.userId = userId;
        this.orderPrice = orderPrice;
        this.items = items;
    }
}
