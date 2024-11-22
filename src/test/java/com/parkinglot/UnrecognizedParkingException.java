package com.parkinglot;

public class UnrecognizedParkingException extends RuntimeException{

    public static final String UNRECOGNIZED_PARKING_TICKET_ERROR = "Unrecognized parking ticket.";

    public UnrecognizedParkingException() {
        super(UNRECOGNIZED_PARKING_TICKET_ERROR);
    }
}
