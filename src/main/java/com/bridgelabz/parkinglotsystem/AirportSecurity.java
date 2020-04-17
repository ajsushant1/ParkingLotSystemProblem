package com.bridgelabz.parkinglotsystem;

public class AirportSecurity implements ParkingLotObserver {
    boolean isParkingFull;

    @Override
    public void updateParkingStatus(boolean parkingStatus) {
        this.isParkingFull = parkingStatus;
    }
}
