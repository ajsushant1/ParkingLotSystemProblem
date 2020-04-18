package com.bridgelabz.parkinglotsystem;

public class ParkingLotManager implements ParkingLotInformer {
    private ParkingLotOwner parkingLotOwner;
    private AirportSecurity airportSecurity;

    public ParkingLotManager() {
        parkingLotOwner = new ParkingLotOwner();
        airportSecurity = new AirportSecurity();
    }

    @Override
    public void notifyParkingStatus(boolean status) throws ParkingLotSystemException {
        parkingLotOwner.updateParkingStatus(status);
        airportSecurity.updateParkingStatus(status);
    }
}
