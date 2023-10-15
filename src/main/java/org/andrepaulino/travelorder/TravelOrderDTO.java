package org.andrepaulino.travelorder;

import org.andrepaulino.flight.Flight;
import org.andrepaulino.hotel.Hotel;

import lombok.Data;

@Data
public class TravelOrderDTO {
    private String fromAirport;
    private String toAirport;
    private Integer nights;

    public TravelOrderDTO() {
    }

    public TravelOrderDTO(String fromAirport, String toAirport, Integer nights) {
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.nights = nights;
    }

    public static TravelOrderDTO of(TravelOrder order, Flight flight, Hotel hotel) {
        return new TravelOrderDTO(flight.getFromAirport(), flight.getToAirport(), hotel.getNights());
    }

    public static TravelOrderDTO of(String fromAirport, String toAirport, Integer nights) {
        return new TravelOrderDTO(fromAirport, toAirport, nights);
    }
}
