package edu.franklin;

import java.util.UUID;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
public class Purchase extends PanacheEntity {
    @NotNull
    public UUID order_id;

    @NotNull
    public Long customer_id;

    @NotNull
    public Long product_id;

    public Float amount;
}
