package com.bridgelabz.parkinglotsystem;

public class Vehicle {
    ParkingDateTime parkingDateTime;
    VehicleType vehicleType;
    VehicleSize vehicleSize;
    private String parkingDateAndTime;
    private String vehicleId;

    public Vehicle(String vehicleId, VehicleType vehicleType, VehicleSize vehicleSize) {
        parkingDateTime = new ParkingDateTime();
        this.vehicleId = vehicleId;
        parkingDateAndTime = parkingDateTime.getDateTime();
        this.vehicleType = vehicleType;
        this.vehicleSize = vehicleSize;
    }

    public String getParkingDateAndTime() {
        return parkingDateAndTime;
    }

    public enum VehicleType {
        NORMAL, HANDICAP
    }

    public enum VehicleSize {
        SMALL, LARGE
    }
}
