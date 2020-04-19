package com.bridgelabz.parkinglotsystem;

public class ParkingLotOwner implements ParkingLotObserver {
    ParkingLotSystem parkingLotSystem;
    private boolean isParkingFull;
    public ParkingLotOwner() {
        parkingLotSystem = new ParkingLotSystem();
    }

    @Override
    public void updateParkingStatus(boolean parkingStatus) {
        isParkingFull = parkingStatus;
    }
}
