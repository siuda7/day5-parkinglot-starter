package com.parkinglot;

public class ParkingBoy {

    ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    Ticket park(Car car) {
        return parkingLot.park(car);
    }
}
