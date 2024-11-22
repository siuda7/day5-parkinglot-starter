package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    public static final String UNRECOGNIZED_PARKING_TICKET_ERROR = "Unrecognized parking ticket.";
    private Map<Ticket, Car> parkingRecord = new HashMap<>();

    private static final int maxCapacity = 10;

    public Ticket park(Car car) {
        if (parkingRecord.size() == maxCapacity) return null;
        Ticket ticket = new Ticket(car);
        parkingRecord.put(ticket, car);
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        try {
            Car car = parkingRecord.get(ticket);
            parkingRecord.remove(ticket);
            return car;
        } catch (Exception e){
            System.out.println(UNRECOGNIZED_PARKING_TICKET_ERROR);
            return null;
        }
    }
}
