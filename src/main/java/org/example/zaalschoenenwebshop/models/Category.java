package org.example.zaalschoenenwebshop.models;



import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    private Set<ZaalSchoen> zaalSchoenen;

    public Category(String name) {
        this.name = name;
    }

    public Category() {

    }

    public Set<ZaalSchoen> getZaalSchoenen() {
        return this.zaalSchoenen;
    }

    public void setZaalSchoenen(Set<ZaalSchoen> zaalSchoens) {
        this.zaalSchoenen = zaalSchoens;
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
}