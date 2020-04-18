package com.bridgelabz.parkinglotsystem;

public interface ParkingLotInformer {
    void notifyParkingStatus(boolean status) throws ParkingLotSystemException;
}
