package org.example.zaalschoenenwebshop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ZaalSchoenDTO {

    @JsonProperty("product_name")
    public String name;

    @JsonProperty("product_description")
    public String description;

    @JsonProperty("category_id")
    public long categoryId;

    @JsonProperty("product_price")
    public double price;

    @JsonProperty("merk")
    public String merk;

    public ZaalSchoenDTO(String name, String description, long categoryId, double price, String merk) {
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
        this.price = price;
        this.merk = merk;
    }
}