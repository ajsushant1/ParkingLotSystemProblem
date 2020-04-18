package com.bridgelabz.parkinglotsystem;

public class ParkingLotOwner implements ParkingLotObserver {
    boolean isParkingFull;
    private ParkingLotSystem parkingLotSystem;
    @Override
    public void updateParkingStatus(boolean parkingStatus) throws ParkingLotSystemException {
        parkingLotSystem=new ParkingLotSystem();
        if (parkingStatus == true) {
            this.isParkingFull = parkingStatus;
            throw new ParkingLotSystemException(ParkingLotSystemException.ExceptionType.PARKING_FULL, "Parking is full");
        }
        parkingLotSystem.isParkingFull = false;
    }
}
