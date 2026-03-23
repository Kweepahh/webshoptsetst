package org.example.zaalschoenenwebshop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderItemDTO {

    @JsonProperty("item_id")
    public long orderItemId;

    @JsonProperty("order_id")
    public Long orderId;

    @JsonProperty("product_name")
    public String productName;

    @JsonProperty("item_quantity")
    public int quantity;

    @JsonProperty("item_price")
    public double price;

    public OrderItemDTO(long orderItemId, Long orderId, String productName, int quantity, double price) {
        this.orderItemId = orderItemId;
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
}