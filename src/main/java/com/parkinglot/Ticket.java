package com.parkinglot;

public class Ticket {

    private Car car;

    private boolean isUsed = false;

    public Ticket(Car car) {
        this.car = car;
    }

    public void useTicket() {
        isUsed = true;
    }

    public boolean isUsedTicket() {
        return isUsed;
    }
}
