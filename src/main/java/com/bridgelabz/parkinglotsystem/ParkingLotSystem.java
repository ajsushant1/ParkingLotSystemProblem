package com.bridgelabz.parkinglotsystem;

public class ParkingLotSystem {
    private Object vehicle;

    public static void main(String[] args) {
        System.out.println("/**************************/ WELCOME TO PARKING LOT SYSTEM /**************************/");
    }

    public void park(Object vehicle) throws ParkingLotSystemException {
        if (this.vehicle != null)
            throw new ParkingLotSystemException(ParkingLotSystemException.ExceptionType.PARKING_FULL, "Parking is full");
        this.vehicle = vehicle;
    }

    public void unPark(Object vehicle) throws ParkingLotSystemException {
        if (this.vehicle != null && !this.vehicle.equals(vehicle)) {
            throw new ParkingLotSystemException(ParkingLotSystemException.ExceptionType.NO_VEHICLE, "NO vehicle");
        }
        this.vehicle = null;
    }

    public boolean isVehiclePark(Object vehicle) {
        return this.vehicle.equals(vehicle);
    }

    public boolean isVehicleUnPark() {
        return this.vehicle == null;
    }
}
