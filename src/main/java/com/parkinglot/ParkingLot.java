package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private Map<Ticket, Car> parkingRecord = new HashMap<>();
    private static final Integer maxCapacity = 10;

    public boolean isNotFull() {
        return parkingRecord.size() < maxCapacity;
    }

    public boolean containsTicket(Ticket ticket) {
        return parkingRecord.containsKey(ticket);
    }

    public boolean containsCar(Car car) {
        return parkingRecord.containsValue(car);
    }

    public Ticket park(Car car) {
        try {
            if (parkingRecord.size() == maxCapacity) {
                throw new NoAvailablePositionException();
            }
            Ticket ticket = new Ticket(car);
            parkingRecord.put(ticket, car);
            return ticket;
        } catch (Exception e) {
            return null;
        }
    }

    public Car fetch(Ticket ticket) {
        try {
            if (ticket.isUsedTicket()) throw new UnrecognizedParkingException();
            Car car = parkingRecord.get(ticket);
            ticket.useTicket();
            parkingRecord.remove(ticket);
            return car;
        } catch (Exception e){
            return null;
        }
    }

    public Integer getFreeCapacity() {
        return maxCapacity - parkingRecord.size();
    }
}
