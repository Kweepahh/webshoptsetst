package org.example.zaalschoenenwebshop.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
public class ZaalSchoen {
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String name;

    @NotNull
    private double price

    @NotNull
    private String description;

    @NotNull
    private String merk;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    private Category category;

    public ZaalSchoen() {
    }

    public ZaalSchoen(String name, String description, Category category, String merk) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.merk = merk;
    }

    public ZaalSchoen(String name, String description, Category category) {
    }


    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
