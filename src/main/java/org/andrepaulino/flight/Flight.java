package org.andrepaulino.flight;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Flight extends PanacheEntity {
    private Long travelOrderId;
    private String fromAirport;
    private String toAirport;

    public void setIdToNull() {
        super.id = null;
    }

    public static List<Flight> findByTravelOrderId(Long travelOrderId) {
        return find("travelOrderId", travelOrderId).list();
    }
}
