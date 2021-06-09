package com.example.beadando.manufacturer;

import com.example.beadando.car.CarEntity;

import java.util.List;

public class ManufacturerListResponse {
    private List<CarEntity> cars;

    public List<CarEntity> getCars() {
        return cars;
    }

    public void setCars(List<CarEntity> cars) {
        this.cars = cars;
    }
}
