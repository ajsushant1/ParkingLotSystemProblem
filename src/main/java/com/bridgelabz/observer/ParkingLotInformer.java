package com.bridgelabz.observer;

import com.bridgelabz.observer.ParkingLotObserver;

public interface ParkingLotInformer {
    void addObserver(ParkingLotObserver lotObserver);

    void notifyParkingStatus(boolean parkingStatus);
}
