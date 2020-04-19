package com.bridgelabz.parkinglotsystem;

public interface ParkingLotInformer {
    void addObserver(ParkingLotObserver lotObserver);

    void notifyParkingStatus(boolean parkingStatus);
}
