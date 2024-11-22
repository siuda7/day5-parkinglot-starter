package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingBoyTest {

    @Test
    void should_return_ticket_when_park_given__car_and_parking_boy() {

        //Given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        //When
        Ticket ticket = parkingBoy.park(car);

        //Then
        assertNotNull(ticket);

    }

    @Test
    void should_return_car_when_fetch_given_parking_lot_and_ticket() {

        //Given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        //When
        Ticket ticket = parkingBoy.park(car);

        Car fetchCar = parkingBoy.fetch(ticket);

        //Then
        assertEquals(car, fetchCar);

    }

}
