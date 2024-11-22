package com.parkinglot;

import java.util.Comparator;
import java.util.List;

public class SuperParkingBoy extends ParkingBoy{

    public SuperParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    Ticket park(Car car) {
        ParkingLot mostFreeparkingLot = this.parkingLots.stream()
                .filter(ParkingLot::isNotFull)
                .max(Comparator.comparing(ParkingLot::getFreeCapacityRate))
                .orElseThrow(NoAvailablePositionException::new);
        return mostFreeparkingLot.park(car);
    }
}
