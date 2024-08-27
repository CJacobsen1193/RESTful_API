package franklin.edu;

import java.time.Instant;
import java.util.UUID;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Report extends PanacheEntity {

    public UUID order_id;
    public Long customer_id;
    public Long product_id;
    public Instant time;
    public Float amount;

    public Report() {

    }

}
