package com.example.beadando.manufacturer;

import com.example.beadando.car.CarEntity;

import java.util.List;

public class ManufacturerListResponse {
    private List<ManufacturerEntity> manufacturers;

    public ManufacturerListResponse() {

    }

    public List<ManufacturerEntity> getManufacturers() {
        return manufacturers;
    }

    public ManufacturerListResponse(List<ManufacturerEntity> manufacturers) {
        this.manufacturers = manufacturers;
    }

    public void setManufacturers(List<ManufacturerEntity> manufacturers) {
        this.manufacturers = manufacturers;
    }
}
