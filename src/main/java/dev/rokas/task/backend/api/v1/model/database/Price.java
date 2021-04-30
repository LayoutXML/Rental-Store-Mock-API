package dev.rokas.task.backend.api.v1.model.database;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Price {
    @Id
    private long id;

    private Integer commitmentMonths;
    private Double value;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "product_price",
            joinColumns = @JoinColumn(name = "price_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Product product;
}
