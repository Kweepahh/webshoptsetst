package org.example.zaalschoenenwebshop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class OrderDTO {

    @JsonProperty("order_id")
    public long id;

    @JsonProperty("order_date")
    public LocalDate orderDate;

    @JsonProperty("user_id")
    public long userId;

    @JsonProperty("order_price")
    public long orderPrice;

    public List<OrderItemDTO> items;
}
