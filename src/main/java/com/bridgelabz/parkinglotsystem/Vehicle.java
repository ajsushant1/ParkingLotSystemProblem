package com.bridgelabz.parkinglotsystem;

public class Vehicle {
    ParkingDateTime parkingDateTime;
    VehicleType vehicleType;
    VehicleSize vehicleSize;
    private String parkingDateAndTime;
    private String vehicleId;
    Color color;

    public Vehicle(String vehicleId, VehicleType vehicleType, VehicleSize vehicleSize, Color color) {
        parkingDateTime = new ParkingDateTime();
        this.vehicleId = vehicleId;
        parkingDateAndTime = parkingDateTime.getDateTime();
        this.vehicleType = vehicleType;
        this.vehicleSize = vehicleSize;
        this.color=color;
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

    public enum Color {BLACK, BLUE, WHITE}
}
