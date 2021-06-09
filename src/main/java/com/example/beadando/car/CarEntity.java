package com.example.beadando.car;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "car")
@Entity
public class CarEntity {
    @Id
    private Long ID;
    @Column(name = "Type")
   private  String type;
    @Column(name = "Manufacturer")
   private String manufacturer;
    @Column(name = "Door_Number")
   private int door_number;
    @Column(name = "Manufacturer_Year")
   private int manufacturer_year;

    public CarEntity() {
    }

    public CarEntity(Long ID, String type, String manufacturer, int door_number, int manufacturer_year) {
        this.ID = ID;
        this.type = type;
        this.manufacturer = manufacturer;
        this.door_number = door_number;
        this.manufacturer_year = manufacturer_year;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long id) {
        this.ID = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getDoor_number() {
        return door_number;
    }

    public void setDoor_number(int door_number) {
        this.door_number = door_number;
    }

    public int getManufacturer_year() {
        return manufacturer_year;
    }

    public void setManufacturer_year(int manufacturer_year) {
        this.manufacturer_year = manufacturer_year;
    }
}
