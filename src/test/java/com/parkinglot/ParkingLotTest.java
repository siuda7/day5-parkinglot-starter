package com.parkinglot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    
    @Test
    void should_return_ticket_when_park_given_a_car() {
    
        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //When
        Ticket ticket = parkingLot.park(car);

        //Then
        assertNotNull(ticket);

    }

    @Test
    void should_return_car_when_fetch_given_ticket() {

        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);

        //When
        Car fetchedCar = parkingLot.fetch(ticket);

        //Then
        assertEquals(car, fetchedCar);

    }

    @Test
    void should_return_2_correct_cars_when_fetch_twice_given_2_cars() {

        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        Ticket ticket1 = parkingLot.park(car1);
        Car car2 = new Car();
        Ticket ticket2 = parkingLot.park(car2);

        //When
        Car fetchCar1 = parkingLot.fetch(ticket1);
        Car fetchCar2 = parkingLot.fetch(ticket2);

        //Then
        assertEquals(car1, fetchCar1);
        assertEquals(car2, fetchCar2);

    }

    @Test
    void should_return_nothing_when_fetch_given_parking_lot_and_wrong_ticket() {

        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car wrongCar = new Car();
        parkingLot.park(wrongCar);

        Car correctCar = new Car();
        Ticket correctTicket = new Ticket(correctCar);

        //When
        Car fetchWrongCar = parkingLot.fetch(correctTicket);

        //Then
        assertNull(fetchWrongCar);

    }
    
}
