package com.bridgelabz.exception;

public class ParkingLotSystemException extends Exception {

    public ExceptionType type;

    public ParkingLotSystemException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }

    public enum ExceptionType {NO_VEHICLE, ALREADY_PARKED, PARKING_FULL}
}
