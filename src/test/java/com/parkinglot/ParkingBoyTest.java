package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingBoyTest {

    private ParkingLot getFullParkingLot() {

        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        IntStream.range(0, 10).forEach(index -> parkingLot.park(car));

        return parkingLot;
    }

    @Test
    void should_return_ticket_when_park_given__car_and_parking_boy() {

        //Given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(List.of(parkingLot));
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
        ParkingBoy parkingBoy = new ParkingBoy(List.of(parkingLot));
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
        ParkingBoy parkingBoy = new ParkingBoy(List.of(parkingLot));

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
        ParkingBoy parkingBoy = new ParkingBoy(List.of(parkingLot));
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
    
    @Test
    void should_return_unrecognized_err_msg_and_nothing_when_fetch_given_parking_lot_parking_boy_and_used_ticket() {

        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(List.of(parkingLot));
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);

        //When
        parkingBoy.fetch(ticket);
        Car fetchSameCar = parkingBoy.fetch(ticket);

        //Then
        assertNull(fetchSameCar);
        Exception unRecognizedTicketException =  assertThrows(UnrecognizedParkingException.class, () -> {
            throw new UnrecognizedParkingException();
        });
        assertEquals("Unrecognized parking ticket.", unRecognizedTicketException.getMessage());
    }

    @Test
    void should_return_no_available_position_when_fetch_given_full_parking_lot_and_parking_boy() {

        //Given
        ParkingLot parkingLot = getFullParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(List.of(parkingLot));
        Car car = new Car();

        //When
        Ticket ticket = parkingBoy.park(car);

        //Then
        assertNull(ticket);
        Exception exception =  assertThrows(NoAvailablePositionException.class, () -> {
            throw new NoAvailablePositionException();
        });
        assertEquals("No available position.", exception.getMessage());

    }

    @Test
    void should_return_ticket_and_park_in_first_parking_lot_when_park_given_2_parking_lot_parking_boy_both_lots_available() {

        //Given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();

        Car car = new Car();

        ParkingBoy parkingBoy = new ParkingBoy(List.of(parkingLot1, parkingLot2));

        //When
        Ticket ticket = parkingBoy.park(car);

        //Then
        assertNotNull(ticket);
        assertTrue(parkingLot1.containsCar(car));

    }

    @Test
    void should_return_ticket_and_park_in_second_parking_lot_when_park_given_first_parking_lot_full_and_second_parking_lot_available() {

        ParkingLot parkingLot1 = getFullParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();

        Car car = new Car();

        ParkingBoy parkingBoy = new ParkingBoy(List.of(parkingLot1, parkingLot2));

        //When
        Ticket ticket = parkingBoy.park(car);

        //Then
        assertNotNull(ticket);
        assertTrue(parkingLot2.containsCar(car));
    }

    @Test
    void should_return_2_correct_car_when_fetch_given_car_in_both_parking_lot() {

        //Given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();

        Car car1 = new Car();
        Car car2 = new Car();

        ParkingBoy parkingBoy = new ParkingBoy(List.of(parkingLot1, parkingLot2));

        //When
        Ticket ticket1 = parkingLot1.park(car1);
        Ticket ticket2 = parkingLot2.park(car2);

        Car fetchCar1 = parkingBoy.fetch(ticket1);
        Car fetchCar2 = parkingBoy.fetch(ticket2);

        //Then
        assertNotNull(fetchCar1);
        assertNotNull(fetchCar2);
        assertEquals(car1, fetchCar1);
        assertEquals(car2, fetchCar2);
    }
}
