package com.example.beadando.car;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Car garage")
@Entity
public class CarEntity {
    @Id
    private Long id;
    @Column(name = "type")
   private  String type;
    @Column(name = "manufacturer")
   private String manufacturer;
    @Column(name = "door_number")
   private int door_number;
    @Column(name = "manufacturer_year")
   private int manufacturer_year;

    public CarEntity() {
    }

    public CarEntity(Long id, String type, String manufacturer, int door_number, int manufacturer_year) {
        this.id = id;
        this.type = type;
        this.manufacturer = manufacturer;
        this.door_number = door_number;
        this.manufacturer_year = manufacturer_year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
