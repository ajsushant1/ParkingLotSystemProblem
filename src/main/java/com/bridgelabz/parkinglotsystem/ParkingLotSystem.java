package com.bridgelabz.parkinglotsystem;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotSystem {
    int SIZE_OF_LOT;
    int NO_OF_LOTS;
    ParkingLotManager parkingLotManager;
    ParkingLotOwner parkingLotOwner;
    AirportSecurity airportSecurity;
    ParkingAttendant parkingAttendant;
    Map<String, Vehicle> vehicleMap;

    //CONSTRUCTOR
    public ParkingLotSystem(int NO_OF_LOTS, int SIZE_OF_LOT) {
        this.SIZE_OF_LOT = SIZE_OF_LOT;
        this.NO_OF_LOTS = NO_OF_LOTS;
        parkingLotManager = new ParkingLotManager();
        parkingLotOwner = new ParkingLotOwner();
        airportSecurity = new AirportSecurity();
        parkingLotManager.addObserver(parkingLotOwner);
        parkingLotManager.addObserver(airportSecurity);
        parkingAttendant = new ParkingAttendant(this);
        vehicleMap = new HashMap<>();
    }

    public ParkingLotSystem() {
    }

    //METHOD TO PARK VEHICLE
    public void park(Vehicle vehicle) throws ParkingLotSystemException {
        if (isLotFull()) {
            parkingLotManager.notifyParkingStatus(true);
            throw new ParkingLotSystemException(ParkingLotSystemException.ExceptionType.PARKING_FULL, "Parking is full");
        }
        parkingAttendant.parkVehicle(vehicle);
    }

    //METHOD TO CHECK LOT IS FULL OR NOT
    public boolean isLotFull() {
        return vehicleMap.size() == SIZE_OF_LOT * NO_OF_LOTS;
    }

    //METHOD TO UNPARK VEHICLE
    public void unPark(Vehicle vehicle) throws ParkingLotSystemException {
        if (!isVehicleParked(vehicle)) {
            throw new ParkingLotSystemException(ParkingLotSystemException.ExceptionType.NO_VEHICLE, "NO vehicle");
        }
        parkingAttendant.unParkedVehicle(vehicle);
        parkingLotManager.notifyParkingStatus(false);
    }

    //METHOD TO CHECK VEHICLE PARKED OR NOT
    public boolean isVehicleParked(Vehicle vehicle) {
        return vehicleMap.containsValue(vehicle);
    }

    //METHOD TO CHECK VEHICLE UNPARKED OR NOT
    public boolean isVehicleUnPark(Vehicle vehicle) {
        return !isVehicleParked(vehicle);
    }

    public String getVehiclePosition(Vehicle vehicle) {
        return parkingAttendant.getVehiclePosition(vehicle);
    }
}
