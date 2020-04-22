package com.bridgelabz.parkinglotsystem;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PoliceDepartment {
    ParkingLotSystem parkingLotSystem;
    Map<String, Vehicle> vehicles = new HashMap<>();

    public PoliceDepartment(ParkingLotSystem parkingLotSystem) {
        this.parkingLotSystem = parkingLotSystem;
    }

    public Map<String, Vehicle> getVehicles(Vehicle.Color color) {
        return vehicles = parkingLotSystem.vehicleMap.entrySet().stream().filter(entry -> color.equals(entry.getValue().color))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}