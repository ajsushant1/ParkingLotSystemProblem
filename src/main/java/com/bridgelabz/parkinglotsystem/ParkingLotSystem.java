package com.bridgelabz.parkinglotsystem;

import com.bridgelabz.exception.ParkingLotSystemException;
import com.bridgelabz.observer.AirportSecurity;
import com.bridgelabz.observer.ParkingLotManager;
import com.bridgelabz.observer.ParkingLotOwner;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotSystem {
    public Map<String, Vehicle> vehicleMap;
    int SIZE_OF_LOT;
    int NUMBER_OF_LOTS;
    ParkingLotManager parkingLotManager;
    ParkingLotOwner parkingLotOwner;
    AirportSecurity airportSecurity;
    ParkingAttendant parkingAttendant;

    //CONSTRUCTOR
    public ParkingLotSystem(int NUMBER_OF_LOTS, int SIZE_OF_LOT) {
        this.SIZE_OF_LOT = SIZE_OF_LOT;
        this.NUMBER_OF_LOTS = NUMBER_OF_LOTS;
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
        return vehicleMap.size() == SIZE_OF_LOT * NUMBER_OF_LOTS;
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

    //METHOD TO GET VEHICLE PARKING POSITION
    public String getVehiclePosition(Vehicle vehicle) {
        return parkingAttendant.getVehiclePosition(vehicle);
    }

    //METHOD TO GET NUMBER OF VEHICLES IN A LOT
    public int getNumberOfVehicles(int lotNumber) {
        return (int) vehicleMap.keySet().stream().filter(key -> key.contains(lotNumber + "L")).count();
    }
}
