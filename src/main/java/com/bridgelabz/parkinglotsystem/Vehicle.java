package com.bridgelabz.parkinglotsystem;

import java.time.LocalDateTime;

public class Vehicle {
    ParkingDateTime parkingDateTime;
    VehicleType vehicleType;
    VehicleSize vehicleSize;
    String attendantName;
    String brandName;
    Color color;
    public LocalDateTime parkingDateAndTime;
    String plantNumber;

    public Vehicle(String plantNumber, VehicleType vehicleType, VehicleSize vehicleSize, Color color, String brandName, String attendantName) {
        parkingDateTime = new ParkingDateTime();
        this.plantNumber = plantNumber;
        parkingDateAndTime = parkingDateTime.getDateTime();
        this.vehicleType = vehicleType;
        this.vehicleSize = vehicleSize;
        this.color = color;
        this.brandName = brandName;
        this.attendantName = attendantName;
    }

    public enum VehicleType {
        NORMAL, HANDICAP
    }

    public enum VehicleSize {
        SMALL, LARGE
    }

    public enum Color {BLACK, BLUE, WHITE}
}
