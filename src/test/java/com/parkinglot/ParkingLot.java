package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private Map<Ticket, Car> parkingRecord = new HashMap<>();

    private static final int maxCapacity = 10;

    public Ticket park(Car car) {
        if (parkingRecord.size() == maxCapacity) return null;
        Ticket ticket = new Ticket(car);
        parkingRecord.put(ticket, car);
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        if (ticket.isUsed()) return null;
        else {
            ticket.useTicket();
            return parkingRecord.get(ticket);
        }
    }
}
