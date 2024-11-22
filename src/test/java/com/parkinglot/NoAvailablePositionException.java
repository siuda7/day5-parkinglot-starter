package com.parkinglot;

public class NoAvailablePositionException extends RuntimeException {

    public static final String UNRECOGNIZED_PARKING_TICKET_ERROR = "No available position.";

    public NoAvailablePositionException() {
        super(UNRECOGNIZED_PARKING_TICKET_ERROR);
    }
}
