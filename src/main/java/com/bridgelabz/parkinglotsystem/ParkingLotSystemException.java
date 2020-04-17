package com.bridgelabz.parkinglotsystem;

public class ParkingLotSystemException extends Exception {

    public ExceptionType type;

    public ParkingLotSystemException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }

    public enum ExceptionType {NO_VEHICLE, PARKING_FULL}
}
