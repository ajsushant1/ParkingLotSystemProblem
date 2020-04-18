package com.bridgelabz.parkinglotsystem;

public class ParkingLotSystem {
    ParkingLotManager parkingLotManager;
    ParkingLotOwner parkingLotOwner;
    AirportSecurity airportSecurity;
    private Object vehicle;

    //CONSTRUCTOR
    public ParkingLotSystem() {
        parkingLotManager = new ParkingLotManager();
        parkingLotOwner = new ParkingLotOwner();
        airportSecurity = new AirportSecurity();
        parkingLotManager.addObserver(parkingLotOwner);
        parkingLotManager.addObserver(airportSecurity);
    }

    //METHOD TO PARK VEHICLE
    public void park(Object vehicle) throws ParkingLotSystemException {
        if (this.vehicle != null) {
            parkingLotManager.notifyParkingStatus();
            throw new ParkingLotSystemException(ParkingLotSystemException.ExceptionType.PARKING_FULL, "Parking is full");
        }
        this.vehicle = vehicle;
    }

    //METHOD TO PARK VEHICLE
    public void unPark(Object vehicle) throws ParkingLotSystemException {
        if (this.vehicle != null && !this.vehicle.equals(vehicle)) {
            throw new ParkingLotSystemException(ParkingLotSystemException.ExceptionType.NO_VEHICLE, "NO vehicle");
        }
        this.vehicle = null;
    }

    //METHOD TO CHECK VEHICLE PARKED OR NOT
    public boolean isVehiclePark(Object vehicle) {
        return this.vehicle.equals(vehicle);
    }

    //METHOD TO CHECK VEHICLE UNPARKED OR NOT
    public boolean isVehicleUnPark() {
        return this.vehicle == null;
    }
}
