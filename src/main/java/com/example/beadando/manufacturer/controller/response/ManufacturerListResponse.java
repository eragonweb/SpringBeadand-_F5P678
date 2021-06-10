package com.example.beadando.manufacturer.controller.response;

import com.example.beadando.manufacturer.entity.ManufacturerEntity;

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
