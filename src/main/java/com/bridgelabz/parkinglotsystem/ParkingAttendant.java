package com.bridgelabz.parkinglotsystem;

public class ParkingAttendant {
    int lot;
    ParkingLotSystem parkingLotSystem;

    public ParkingAttendant(ParkingLotSystem parkingLotSystem) {
        this.parkingLotSystem = parkingLotSystem;
    }

    public void parkVehicle(Vehicle vehicle) throws ParkingLotSystemException {
        if (parkingLotSystem.isVehicleParked(vehicle)) {
            throw new ParkingLotSystemException(ParkingLotSystemException.ExceptionType.ALREADY_PARKED, "Vehicle is already parked");
        }
        String key = getParkingPosition();
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
        String position = null;
        while (lot++ <= parkingLotSystem.NO_OF_LOTS) {
            for (int index = 1; index < parkingLotSystem.SIZE_OF_LOT; index++) {
                String key = "L".concat(lot + " " + index);
                if (!parkingLotSystem.vehicleMap.containsKey(key)) {
                    position = key;
                    break;
                }
            }
            if (lot == parkingLotSystem.NO_OF_LOTS)
                lot = 0;
            break;
        }
        return position;
    }
}
