package org.example.zaalschoenenwebshop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ZaalSchoenDTO {

    @JsonProperty("product_name")
    public String name;

    @JsonProperty("product_description")
    public String description;

    @JsonProperty("category_id")
    public Long categoryId;

    @JsonProperty("product_price")
    public double price;

    @JsonProperty("merk")
    public String merk;

    public Long id;

    public ZaalSchoenDTO(Long id, String name, String description, Long categoryId, double price, String merk) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
        this.price = price;
        this.merk = merk;
    }
}