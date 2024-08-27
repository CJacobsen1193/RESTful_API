package edu.franklin;

import java.time.Instant;
import java.util.UUID;

public class Report {
    public UUID order_id;
    public Long customer_id;
    public Long product_id;
    public Instant time;
    public Float amount;

    public Report() {
    }

    public Report(UUID order_id, Long customer_id, Long product_id, Instant time, Float amount) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.product_id = product_id;
        this.time = time;
        this.amount = amount;
    }

}
