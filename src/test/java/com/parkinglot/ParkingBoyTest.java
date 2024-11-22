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


    @Test
    void should_return_2_cars_when_fetch_given_parking_lot_parking_boy_2_parked_cars_and_2_tickets() {

        //Given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        Car car1 = new Car();
        Ticket ticket1 = parkingBoy.park(car1);
        Car car2 = new Car();
        Ticket ticket2 = parkingBoy.park(car2);

        //When
        Car fetchCar1 = parkingBoy.fetch(ticket1);
        Car fetchCar2 = parkingBoy.fetch(ticket2);

        //Then
        assertEquals(car1, fetchCar1);
        assertEquals(car2, fetchCar2);

    }

    @Test
    void should_return_unrecognized_err_msg_and_nothing_when_fetch_given_parking_lot_parking_boy_and_wrong_ticket() {

        // Given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Ticket unrecognizedTicket = new Ticket(new Car());

        //When
        Car car =parkingBoy.fetch(unrecognizedTicket);

        //Then
        assertNull(car);
        Exception unRecognizedTicketException =  assertThrows(UnrecognizedParkingException.class, () -> {
            throw new UnrecognizedParkingException();
        });
        assertEquals("Unrecognized parking ticket.", unRecognizedTicketException.getMessage());

    }


}
