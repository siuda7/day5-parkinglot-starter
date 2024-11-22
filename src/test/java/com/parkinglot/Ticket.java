package com.parkinglot;

public class Ticket {

    private Car car;

    private boolean isUsed = false;

    public Ticket(Car car) {
        this.car = car;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void useTicket() {
        isUsed = true;
    }
}
