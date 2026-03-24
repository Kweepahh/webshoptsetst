package org.example.zaalschoenenwebshop.dto;

public class OrderResponse {
    private String message;
    private String status;

    public OrderResponse(String message, String status) {
        this.message = message;
        this.status = status;
    }
}