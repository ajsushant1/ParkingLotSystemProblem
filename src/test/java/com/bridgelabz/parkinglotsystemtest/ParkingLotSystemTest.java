package com.bridgelabz.parkinglotsystemtest;

import com.bridgelabz.parkinglotsystem.ParkingLotSystem;
import org.junit.Assert;
import org.junit.Test;

public class ParkingLotSystemTest {
    ParkingLotSystem parkingLotSystem = new ParkingLotSystem();

    @Test
    public void givenAVehicle_WhenParked_ShouldReturnTrue() {
        boolean isPark = parkingLotSystem.park(new Object());
        Assert.assertEquals(true, isPark);
    }
}
