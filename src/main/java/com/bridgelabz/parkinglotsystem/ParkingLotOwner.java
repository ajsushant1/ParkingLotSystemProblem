package com.bridgelabz.parkinglotsystem;

public class ParkingLotOwner implements ParkingLotObserver {
    private boolean isParkingFull;

    @Override
    public void updateParkingStatus() {
        isParkingFull = true;
    }
}
