package com.bridgelabz.parkinglotsystem;

public class ParkingAttendant {
    ParkingLotSystem parkingLotSystem;

    public ParkingAttendant(ParkingLotSystem parkingLotSystem) {
        this.parkingLotSystem = parkingLotSystem;
    }

    public void parkVehicle(Vehicle vehicle) throws ParkingLotSystemException {
        if (parkingLotSystem.isVehicleParked(vehicle)) {
            throw new ParkingLotSystemException(ParkingLotSystemException.ExceptionType.ALREADY_PARKED, "Vehicle is already parked");
        }
        String key = "VH " + parkingLotSystem.vehicleMap.size() + 1;
        parkingLotSystem.vehicleMap.put(key, vehicle);
    }

    public void unParkedVehicle(Vehicle vehicle) {
        parkingLotSystem.vehicleMap.entrySet().removeIf(entry -> vehicle.equals(entry.getValue()));
    }
}
