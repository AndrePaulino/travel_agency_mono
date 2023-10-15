package org.andrepaulino.travelorder;

import java.util.List;
import java.util.stream.Collectors;

import org.andrepaulino.flight.Flight;
import org.andrepaulino.flight.FlightResource;
import org.andrepaulino.hotel.Hotel;
import org.andrepaulino.hotel.HotelResource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("travelorder")
public class TravelOrderResource {

    @Inject
    FlightResource flightResource;
    @Inject
    HotelResource hotelResource;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TravelOrderDTO> orders() {
        return TravelOrder.<TravelOrder>listAll().stream()
                .map(
                        order -> TravelOrderDTO.of(
                                order,
                                flightResource.findByTravelOrderId(order.getId()),
                                hotelResource.findByTravelOrderId(order.getId())))
                .collect(Collectors.toList());
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public TravelOrder findById(@QueryParam("id") long id) {
        return TravelOrder.findById(id);
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TravelOrder newTravelOrder(TravelOrderDTO orderDto) {
        TravelOrder order = new TravelOrder();
        order.setIdToNull();
        order.persist();

        Flight flight = new Flight();
        flight.setTravelOrderId(order.getId());
        flight.setFromAirport(orderDto.getFromAirport());
        flight.setToAirport(orderDto.getToAirport());
        flightResource.newFlight(flight);

        Hotel hotel = new Hotel();
        hotel.setTravelOrderId(order.getId());
        hotel.setNights(orderDto.getNights());
        hotelResource.newHotel(hotel);

        return order;
    }

}
