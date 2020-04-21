package com.bridgelabz.parkinglotsystem;

public class Vehicle {
    ParkingDateTime parkingDateTime;
    VehicleType vehicleType;
    private String parkingDateAndTime;
    private String vehicleId;

    public Vehicle(String vehicleId, VehicleType vehicleType) {
        parkingDateTime = new ParkingDateTime();
        this.vehicleId = vehicleId;
        parkingDateAndTime = parkingDateTime.getDateTime();
        this.vehicleType = vehicleType;
    }

    public String getParkingDateAndTime() {
        return parkingDateAndTime;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public enum VehicleType {
        NORMAL, HANDICAP
    }
}
