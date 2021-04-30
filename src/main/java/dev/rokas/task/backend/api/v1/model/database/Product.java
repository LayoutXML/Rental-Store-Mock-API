package dev.rokas.task.backend.api.v1.model.database;

import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Entity
public class Product {
    @Id
    private long id;

    private String title;
    private boolean rentable;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_price",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "price_id"))
    private Set<Price> prices;
}
