package com.bridgelabz.parkinglotsystem;

public class ParkingLotSystem {
    private Object vehicle;

    public static void main(String[] args) {
        System.out.println("/**************************/ WELCOME TO PARKING LOT SYSTEM /**************************/");
    }

    public boolean park(Object vehicle) {
        if (this.vehicle != null)
            return false;
        this.vehicle = vehicle;
        return true;
    }

    public boolean unPark(Object vehicle) {
        if (this.vehicle != null && this.vehicle.equals(vehicle)) {
            this.vehicle = null;
            return true;
        }
        return false;
    }
}
