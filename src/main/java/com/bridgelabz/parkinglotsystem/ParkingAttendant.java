package com.bridgelabz.parkinglotsystem;

import com.bridgelabz.exception.ParkingLotSystemException;

public class ParkingAttendant {
    int character = 64;
    ParkingLotSystem parkingLotSystem;

    public ParkingAttendant(ParkingLotSystem parkingLotSystem) {
        this.parkingLotSystem = parkingLotSystem;
    }

    public void parkVehicle(Vehicle vehicle) throws ParkingLotSystemException {
        if (parkingLotSystem.isVehicleParked(vehicle)) {
            throw new ParkingLotSystemException(ParkingLotSystemException.ExceptionType.ALREADY_PARKED, "Vehicle is already parked");
        }
        String key = (vehicle.vehicleSize == Vehicle.VehicleSize.LARGE) ? getPositionWithMinimumVehicle() : getParkingPosition();
        parkingLotSystem.vehicleMap.put(key, vehicle);
    }

    public void unParkedVehicle(Vehicle vehicle) {
        parkingLotSystem.vehicleMap.entrySet().removeIf(entry -> vehicle.equals(entry.getValue()));
    }

    public String getVehiclePosition(Vehicle vehicle) {
        return parkingLotSystem.vehicleMap.keySet().stream()
                .filter(key -> vehicle.equals(parkingLotSystem.vehicleMap.get(key)))
                .findFirst()
                .get();
    }

    public String getParkingPosition() {
        int slotNumber = 0;
        String position = null;
        while (slotNumber++ <= parkingLotSystem.SIZE_OF_LOT) {
            char row = (char) (character + slotNumber);
            int flag = 0;
            for (int lotNumber = 1; lotNumber <= parkingLotSystem.NUMBER_OF_LOTS; lotNumber++) {
                String key = lotNumber + "L" + row + " " + slotNumber;
                if (!parkingLotSystem.vehicleMap.containsKey(key)) {
                    position = key;
                    flag = 1;
                    break;
                }
            }
            if (flag == 1)
                break;
        }
        return position;
    }

    public String getPositionWithMinimumVehicle() throws ParkingLotSystemException {
        int count = 0;
        int character = 65;
        while (count++ < parkingLotSystem.NUMBER_OF_LOTS) {
            int numberOfVehicles = parkingLotSystem.getNumberOfVehicles(count);
            char row = (char) (character + numberOfVehicles);
            if (parkingLotSystem.getNumberOfVehicles(count) < (parkingLotSystem.SIZE_OF_LOT - 1)) {
                return count + "L" + row + " " + (parkingLotSystem.getNumberOfVehicles(count) + 1);
            }
        }
        throw new ParkingLotSystemException(ParkingLotSystemException.ExceptionType.PARKING_FULL, "No space for large vehicle");
    }
}
