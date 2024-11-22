package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SuperParkingBoyTest {

    @Test
    void should_park_to_first_parking_lot_when_park_given_smart_parking_boy_and_2_parking_lot_and_first_parking_lot_more_space() {

        //Given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();

        Car car1 = new Car();
        parkingLot2.park(car1);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(List.of(parkingLot1, parkingLot2));

        //When
        Car car2 = new Car();
        Ticket ticket = superParkingBoy.park(car2);

        //The
        assertNotNull(ticket);
        assertTrue(parkingLot1.containsCar(car2));

    }


}
