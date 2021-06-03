package com.example.beadando.car;

import java.util.List;

public class CarListResponse {
    private List<CarEntity> cars;

    public List<CarEntity> getCars() {
        return cars;
    }

    public void setCars(List<CarEntity> cars) {
        this.cars = cars;
    }
}
