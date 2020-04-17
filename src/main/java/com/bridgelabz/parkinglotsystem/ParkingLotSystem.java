package com.bridgelabz.parkinglotsystem;

public class ParkingLotSystem {
    ParkingLotManager parkingLotManager;
    private Object vehicle;

    //CONSTRUCTOR
    public ParkingLotSystem() {
        parkingLotManager = new ParkingLotManager();
    }

    //METHOD TO PARK VEHICLE
    public void park(Object vehicle) throws ParkingLotSystemException {
        if (this.vehicle != null) {
            parkingLotManager.notifyParkingStatus();
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
