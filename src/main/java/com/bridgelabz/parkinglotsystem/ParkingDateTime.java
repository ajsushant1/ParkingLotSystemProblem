package com.bridgelabz.parkinglotsystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParkingDateTime {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    LocalDateTime dateTime = LocalDateTime.now();

    public LocalDateTime getDateTime() {
        String date = formatter.format(dateTime);
        return LocalDateTime.parse(date, formatter);
    }
}
