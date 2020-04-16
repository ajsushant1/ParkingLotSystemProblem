package com.bridgelabz.parkinglotsystemtest;

import com.bridgelabz.parkinglotsystem.ParkingLotSystem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotSystemTest {
    ParkingLotSystem parkingLotSystem =null;
    Object vehicle=null;

    @Before
    public void setUp() throws Exception {
        parkingLotSystem=new ParkingLotSystem();
        vehicle=new Object();
    }

    @Test
    public void givenAVehicle_WhenParked_ShouldReturnTrue() {
        boolean isPark = parkingLotSystem.park(vehicle);
        Assert.assertTrue(isPark);
    }

    @Test
    public void givenAVehicle_WhenAllReadyParked_ShouldReturnFalse() {
        parkingLotSystem.park(vehicle);
        boolean isPark = parkingLotSystem.park(vehicle);
        Assert.assertFalse(isPark);
    }

    @Test
    public void givenAVehicle_WhenUnParked_ShouldReturnTrue() {
        parkingLotSystem.park(vehicle);
        boolean isUnPark = parkingLotSystem.unPark(vehicle);
        Assert.assertTrue(isUnPark);
    }

    @Test
    public void givenAVehicle_WhenUnParked_ShouldReturnFalse() {
        boolean isUnPark = parkingLotSystem.unPark(vehicle);
        Assert.assertFalse(isUnPark);
    }
}
