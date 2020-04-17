package com.bridgelabz.parkinglotsystemtest;

import com.bridgelabz.parkinglotsystem.ParkingLotSystem;
import com.bridgelabz.parkinglotsystem.ParkingLotSystemException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotSystemTest {
    ParkingLotSystem parkingLotSystem = null;
    Object vehicle = null;

    @Before
    public void setUp() throws Exception {
        parkingLotSystem = new ParkingLotSystem();
        vehicle = new Object();
    }

    @Test
    public void givenAVehicle_WhenParked_ShouldReturnTrue() {

        try {
            parkingLotSystem.park(vehicle);
            boolean isPark = parkingLotSystem.isVehiclePark(vehicle);
            Assert.assertTrue(isPark);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicle_WhenAllReadyParked_ShouldThrowException() {
        try {
            parkingLotSystem.park(vehicle);
            parkingLotSystem.park(vehicle);
        } catch (ParkingLotSystemException e) {
            Assert.assertEquals(ParkingLotSystemException.ExceptionType.PARKING_FULL, e.type);
        }
    }

    @Test
    public void givenAVehicle_WhenNotParked_ShouldReturnFalse() {
        Object vehicle1 = new Object();
        try {
            parkingLotSystem.park(vehicle);
            boolean isPark = parkingLotSystem.isVehiclePark(vehicle1);
            Assert.assertFalse(isPark);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicle_WhenUnParked_ShouldReturnTrue() {
        try {
            parkingLotSystem.park(vehicle);
            parkingLotSystem.unPark(vehicle);
            boolean isUnPark = parkingLotSystem.isVehicleUnPark();
            Assert.assertTrue(isUnPark);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicle_WhenNoVehicleUnParked_ShouldThrowException() {
        Object vehicle1 = new Object();
        try {
            parkingLotSystem.park(vehicle);
            parkingLotSystem.unPark(vehicle1);
        } catch (ParkingLotSystemException e) {
            Assert.assertEquals(ParkingLotSystemException.ExceptionType.NO_VEHICLE, e.type);
        }
    }

    @Test
    public void givenAVehicle_WhenNotUnParked_ShouldReturnFalse() {
        Object vehicle1 = new Object();
        try {
            parkingLotSystem.park(vehicle);
            boolean isUnPark = parkingLotSystem.isVehicleUnPark();
            Assert.assertFalse(isUnPark);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }
}
