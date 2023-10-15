package org.andrepaulino.hotel;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Hotel extends PanacheEntity {
    private Long travelOrderId;
    private Integer nights;

    public void setIdToNull() {
        this.id = null;
    }

    public static List<Hotel> findByTravelOrderId(Long travelOrderId) {
        return find("travelOrderId", travelOrderId).list();
    }
}
