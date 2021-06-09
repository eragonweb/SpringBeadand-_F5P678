package com.example.beadando.manufacturer;

import com.example.beadando.car.CarEntity;

import java.util.List;

public class ManufacturerListResponse {
    private List<ManufacturerEntity> manufacturer;
    public ManufacturerListResponse(List<ManufacturerEntity> manufacturer) {
        this.manufacturer = manufacturer;
    }

    public ManufacturerListResponse() {

    }

    public List<ManufacturerEntity> getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(List<ManufacturerEntity> manufacturer) {
        this.manufacturer = manufacturer;

    }


}
