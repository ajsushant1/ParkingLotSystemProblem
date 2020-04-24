package com.bridgelabz.observer;

import com.bridgelabz.observer.ParkingLotObserver;

public class AirportSecurity implements ParkingLotObserver {
    private Boolean isParkingFull;

    @Override
    public void updateParkingStatus(boolean parkingStatus) {
        isParkingFull = parkingStatus;
    }
}
