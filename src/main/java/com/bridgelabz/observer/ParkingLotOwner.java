package com.bridgelabz.observer;

import com.bridgelabz.observer.ParkingLotObserver;
import com.bridgelabz.parkinglotsystem.ParkingLotSystem;

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
