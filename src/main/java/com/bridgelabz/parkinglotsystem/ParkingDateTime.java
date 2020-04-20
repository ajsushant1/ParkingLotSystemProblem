package com.bridgelabz.parkinglotsystem;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ParkingDateTime {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    Date date = new Date();

    public String getDateTime() {
        return formatter.format(date);
    }
}
