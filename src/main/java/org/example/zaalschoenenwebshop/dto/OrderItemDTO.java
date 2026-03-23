package org.example.zaalschoenenwebshop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.zaalschoenenwebshop.models.Order;
import org.example.zaalschoenenwebshop.models.ZaalSchoen;

public class OrderItemDTO {

    @JsonProperty("item_id")
    public long orderItemId;

    @JsonProperty("order_id")
    public Order order;

    @JsonProperty("item_product")
    public ZaalSchoen product;

    @JsonProperty("item_quantity")
    public int quantity;

    @JsonProperty("item_price")
    public double price;

    public OrderItemDTO(double price, int quantity, ZaalSchoen product, Order order, long orderItemId) {
        this.price = price;
        this.quantity = quantity;
        this.product = product;
        this.order = order;
        this.orderItemId = orderItemId;
    }
}
