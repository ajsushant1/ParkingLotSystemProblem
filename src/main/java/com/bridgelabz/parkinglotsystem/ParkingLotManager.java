package com.bridgelabz.parkinglotsystem;

public class ParkingLotManager implements ParkingLotInformer {
    private ParkingLotOwner parkingLotOwner;
    private AirportSecurity airportSecurity;

    public ParkingLotManager() {
        parkingLotOwner = new ParkingLotOwner();
        airportSecurity = new AirportSecurity();
    }

    @Override
    public void notifyParkingStatus() throws ParkingLotSystemException {
        parkingLotOwner.updateParkingStatus(true);
        airportSecurity.updateParkingStatus(true);
    }
}
