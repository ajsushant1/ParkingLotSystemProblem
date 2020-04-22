package com.bridgelabz.parkinglotsystemtest;

import com.bridgelabz.parkinglotsystem.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ParkingLotSystemTest {
    ParkingLotSystem parkingLotSystem = null;
    Vehicle vehicle = null;
    ParkingLotOwner parkingLotOwner = null;
    AirportSecurity airportSecurity = null;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    Date date = new Date();
    Vehicle.VehicleSize size;

    @Before
    public void setUp() throws Exception {
        parkingLotSystem = new ParkingLotSystem(2, 3);
        parkingLotOwner = new ParkingLotOwner();
        airportSecurity = new AirportSecurity();
        size = Vehicle.VehicleSize.SMALL;
    }

    @Test
    public void givenAVehicle_WhenParked_ShouldReturnTrue() {
        try {
            vehicle = new Vehicle("1", Vehicle.VehicleType.NORMAL, size);
            parkingLotSystem.park(vehicle);
            boolean isPark = parkingLotSystem.isVehicleParked(vehicle);
            Assert.assertTrue(isPark);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicle_WhenAllReadyParked_ShouldThrowException() {
        parkingLotSystem = new ParkingLotSystem(1, 1);
        try {
            parkingLotSystem.park(new Vehicle("1", Vehicle.VehicleType.NORMAL, size));
            parkingLotSystem.park(new Vehicle("2", Vehicle.VehicleType.NORMAL, size));
            parkingLotSystem.park(new Vehicle("3", Vehicle.VehicleType.NORMAL, size));
        } catch (ParkingLotSystemException e) {
            Assert.assertEquals(ParkingLotSystemException.ExceptionType.PARKING_FULL, e.type);
        }
    }

    @Test
    public void givenAVehicle_WhenNotParked_ShouldReturnFalse() {
        vehicle = new Vehicle("1", Vehicle.VehicleType.NORMAL, size);
        boolean isPark = parkingLotSystem.isVehicleParked(vehicle);
        Assert.assertFalse(isPark);
    }

    @Test
    public void givenAVehicle_WhenUnParked_ShouldReturnTrue() {
        try {
            Vehicle vehicle1 = new Vehicle("1", Vehicle.VehicleType.NORMAL, size);
            parkingLotSystem.park(vehicle1);
            parkingLotSystem.unPark(vehicle1);
            boolean isUnPark = parkingLotSystem.isVehicleUnPark(vehicle1);
            Assert.assertTrue(isUnPark);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicle_WhenNoVehicleUnParked_ShouldThrowException() {
        try {
            Vehicle vehicle1 = new Vehicle("1", Vehicle.VehicleType.NORMAL, size);
            Vehicle vehicle2 = new Vehicle("2", Vehicle.VehicleType.NORMAL, size);
            parkingLotSystem.park(vehicle1);
            parkingLotSystem.unPark(vehicle2);
        } catch (ParkingLotSystemException e) {
            Assert.assertEquals(ParkingLotSystemException.ExceptionType.NO_VEHICLE, e.type);
        }
    }

    @Test
    public void givenAVehicle_WhenNotUnParked_ShouldReturnFalse() {
        Vehicle vehicle1 = new Vehicle("1", Vehicle.VehicleType.NORMAL, size);
        try {
            parkingLotSystem.park(vehicle1);
            boolean isUnPark = parkingLotSystem.isVehicleUnPark(vehicle1);
            Assert.assertFalse(isUnPark);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicle_WhenThereIsSpace_ShouldAllowToPark() {
        Vehicle vehicle1 = new Vehicle("1", Vehicle.VehicleType.NORMAL, size);
        Vehicle vehicle2 = new Vehicle("2", Vehicle.VehicleType.NORMAL, size);
        Vehicle vehicle3 = new Vehicle("3", Vehicle.VehicleType.NORMAL, size);
        try {
            parkingLotSystem.park(vehicle1);
            parkingLotSystem.park(vehicle2);
            parkingLotSystem.unPark(vehicle1);
            parkingLotSystem.park(vehicle3);
            boolean isPark = parkingLotSystem.isVehicleParked(vehicle3);
            Assert.assertTrue(isPark);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicle_WhenAlreadyParked_ShouldThrowException() {
        Vehicle vehicle1 = new Vehicle("1", Vehicle.VehicleType.NORMAL, size);
        try {
            parkingLotSystem.park(vehicle1);
            parkingLotSystem.park(vehicle1);
        } catch (ParkingLotSystemException e) {
            Assert.assertEquals(ParkingLotSystemException.ExceptionType.ALREADY_PARKED, e.type);
        }
    }

    @Test
    public void givenAVehicle_WhenAskForPosition_ShouldReturnPosition() {
        Vehicle vehicle1 = new Vehicle("1", Vehicle.VehicleType.NORMAL, size);
        try {
            parkingLotSystem.park(vehicle1);
            String vehiclePosition = parkingLotSystem.getVehiclePosition(vehicle1);
            Assert.assertEquals("L1 1", vehiclePosition);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicle_WhenParkedWithDateAndTime_ShouldReturnParkingDateTime() {
        vehicle = new Vehicle("1", Vehicle.VehicleType.NORMAL, size);
        try {
            parkingLotSystem.park(vehicle);
            String dateTime = formatter.format(date);
            String parkingDateAndTime = vehicle.getParkingDateAndTime();
            Assert.assertEquals(dateTime, parkingDateAndTime);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicles_WhenParked_ShouldHaveEvenDistributionInLot() {
        Vehicle vehicle1 = new Vehicle("1", Vehicle.VehicleType.NORMAL, size);
        Vehicle vehicle2 = new Vehicle("2", Vehicle.VehicleType.NORMAL, size);
        try {
            parkingLotSystem.park(vehicle1);
            parkingLotSystem.park(vehicle2);
            String vehicle1Position = parkingLotSystem.getVehiclePosition(vehicle1);
            String vehicle2Position = parkingLotSystem.getVehiclePosition(vehicle2);
            Assert.assertEquals("L1 1", vehicle1Position);
            Assert.assertEquals("L2 1", vehicle2Position);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicle_WhenDriverIsHandicap_ShouldParkedVehicleAtNearestPosition() {
        Vehicle vehicle1 = new Vehicle("1", Vehicle.VehicleType.NORMAL, size);
        Vehicle vehicle2 = new Vehicle("2", Vehicle.VehicleType.NORMAL, size);
        Vehicle vehicle3 = new Vehicle("2", Vehicle.VehicleType.HANDICAP, size);
        try {
            parkingLotSystem.park(vehicle1);
            parkingLotSystem.park(vehicle2);
            parkingLotSystem.unPark(vehicle1);
            parkingLotSystem.park(vehicle3);
            String vehicle1Position = parkingLotSystem.getVehiclePosition(vehicle3);
            Assert.assertEquals("L1 1", vehicle1Position);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenVehicle_WhenVehicleSizeLarge_ShouldParkedInMaximumSpaceLot() {
        Vehicle vehicle1 = new Vehicle("1", Vehicle.VehicleType.NORMAL, size);
        Vehicle vehicle2 = new Vehicle("2", Vehicle.VehicleType.NORMAL, size);
        Vehicle vehicle3 = new Vehicle("3", Vehicle.VehicleType.NORMAL, size);
        Vehicle vehicle4 = new Vehicle("4", Vehicle.VehicleType.NORMAL, Vehicle.VehicleSize.LARGE);
        try {
            parkingLotSystem.park(vehicle1);
            parkingLotSystem.park(vehicle2);
            parkingLotSystem.park(vehicle3);
            parkingLotSystem.park(vehicle4);
            String vehiclePosition = parkingLotSystem.getVehiclePosition(vehicle4);
            Assert.assertEquals("L2 2", vehiclePosition);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenLargeVehicle_WhenNoSpaceForLargeVehicle_ShouldThrowException() {
        Vehicle vehicle1 = new Vehicle("1", Vehicle.VehicleType.NORMAL, size);
        Vehicle vehicle2 = new Vehicle("2", Vehicle.VehicleType.NORMAL, size);
        Vehicle vehicle3 = new Vehicle("3", Vehicle.VehicleType.NORMAL, size);
        Vehicle vehicle4 = new Vehicle("4", Vehicle.VehicleType.NORMAL, Vehicle.VehicleSize.LARGE);
        Vehicle vehicle5 = new Vehicle("5", Vehicle.VehicleType.NORMAL, Vehicle.VehicleSize.LARGE);
        try {
            parkingLotSystem.park(vehicle1);
            parkingLotSystem.park(vehicle2);
            parkingLotSystem.park(vehicle3);
            parkingLotSystem.park(vehicle4);
            parkingLotSystem.park(vehicle5);
        } catch (ParkingLotSystemException e) {
            Assert.assertEquals(ParkingLotSystemException.ExceptionType.PARKING_FULL, e.type);
        }
    }
}
