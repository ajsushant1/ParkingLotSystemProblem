package com.bridgelabz.parkinglotsystem;

public class ParkingLotOwner implements ParkingLotObserver {
    boolean isParkingFull;

    @Override
    public void updateParkingStatus(boolean parkingStatus) throws ParkingLotSystemException {
        this.isParkingFull = parkingStatus;
        throw new ParkingLotSystemException(ParkingLotSystemException.ExceptionType.PARKING_FULL, "Parking is full");
    }
}
