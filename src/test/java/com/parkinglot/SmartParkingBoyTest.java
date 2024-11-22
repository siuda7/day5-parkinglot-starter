package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SmartParkingBoyTest {

    @Test
    void should_park_to_first_parking_lot_when_park_given_smart_parking_boy_and_2_parking_lot_and_first_parking_lot_more_space() {

        //Given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();

        Car car1 = new Car();
        parkingLot2.park(car1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(List.of(parkingLot1, parkingLot2));

        //When
        Car car2 = new Car();
        Ticket ticket = smartParkingBoy.park(car2);

        //The
        assertNotNull(ticket);
        assertTrue(parkingLot1.containsCar(car2));

    }

    @Test
    void should_return_park_in_first_parking_lot_when_park_given_() {

        //Given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(List.of(parkingLot1, parkingLot2));

        //When
        Car car = new Car();
        Ticket ticket = smartParkingBoy.park(car);

        //The
        assertNotNull(ticket);
        assertTrue(parkingLot1.containsCar(car));
    }
}
