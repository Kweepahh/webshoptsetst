package org.example.zaalschoenenwebshop.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class ZaalSchoenDTO {
    public String name;
    public String description;

    @JsonAlias("category_id")
    public long categoryId;

    public ZaalSchoenDTO(String name, String description, long categoryId) {
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
    }
}
