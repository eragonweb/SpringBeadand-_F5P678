package com.example.beadando.car.entity;

import com.example.beadando.core.entity.CoreEntity;
import com.example.beadando.manufacturer.entity.ManufacturerEntity;

import javax.persistence.*;

@Table(name = "car")
@Entity
public class CarEntity extends CoreEntity {

    @Column(name = "Type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "Manufacturer_Id")
    private ManufacturerEntity manufacturer;
    @Column(name = "Door_Number")
    private double door_number;
    @Column(name = "Manufacturer_Year")
    private double manufacturer_year;

    public CarEntity() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ManufacturerEntity getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(ManufacturerEntity manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getDoor_number() {
        return door_number;
    }

    public void setDoor_number(double door_number) {
        this.door_number = door_number;
    }

    public double getManufacturer_year() {
        return manufacturer_year;
    }

    public void setManufacturer_year(double manufacturer_year) {
        this.manufacturer_year = manufacturer_year;
    }
}
