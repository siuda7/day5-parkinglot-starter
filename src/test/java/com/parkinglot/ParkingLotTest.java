package com.parkinglot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut() {
        return outContent.toString();
    }
    
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

    @Test
    void should_return_nothing_when_fetch_given_parking_lot_and_used_ticket() {

        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);

        //When
        parkingLot.fetch(ticket);
        Car fetchSameCar = parkingLot.fetch(ticket);

        //Then
        assertNull(fetchSameCar);

    }

    @Test
    void should_return_null_when_park_given_parking_lot_full_and_car() {

        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        // Add 10 cars to parking lot
        IntStream.range(0, 10).forEach(index -> parkingLot.park(car));

        //When
        Ticket ticket = parkingLot.park(car);

        //Then
        assertNull(ticket);

    }

    @Test
    void should_return_unrecognized_ticket_err_msg_when_fetch_given_parking_lot_and_unrecognized_ticket() {

        //Given
        ParkingLot parkingLot = new ParkingLot();
        Ticket unrecognizedTicket = new Ticket(new Car());

        //When
        Car car = parkingLot.fetch(unrecognizedTicket);

        //Then
        assertNull(car);
        Exception unRecognizedTicketException =  assertThrows(Exception.class, () -> {
            throw new Exception("Unrecognized parking ticket.");
        });
        assertEquals("Unrecognized parking ticket.", unRecognizedTicketException.getMessage());

    }

    @Test
    void should_return_unrecognized_ticket_err_msg_when_fetch_given_parking_lot_and_used_ticket() {

        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);

        //When
        parkingLot.fetch(ticket);
        Car fetchSameCar = parkingLot.fetch(ticket);

        //Then
        assertNull(fetchSameCar);
        Exception unRecognizedTicketException =  assertThrows(Exception.class, () -> {
            throw new Exception("Unrecognized parking ticket.");
        });
        assertEquals("Unrecognized parking ticket.", unRecognizedTicketException.getMessage());
    }
    
}
