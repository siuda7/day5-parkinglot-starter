package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

    List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    Ticket park(Car car) {
        try {
            ParkingLot availableParkingLot = this.parkingLots.stream()
                    .filter(ParkingLot::isNotFull)
                    .findFirst()
                    .orElseThrow(NoAvailablePositionException::new);
            return availableParkingLot.park(car);
        } catch (Exception e) {
            return null;
        }
    }

    public Car fetch(Ticket ticket) {
        try {
            ParkingLot correctParkingLot = this.parkingLots.stream()
                    .filter(parkingLot -> parkingLot.containsTicket(ticket))
                    .findFirst()
                    .orElseThrow(UnrecognizedParkingException::new);
            return correctParkingLot.fetch(ticket);
        } catch (Exception e) {
            return null;
        }
    }
}
