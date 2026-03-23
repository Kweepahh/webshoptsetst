package org.example.zaalschoenenwebshop.models;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private CustomUser user;



}