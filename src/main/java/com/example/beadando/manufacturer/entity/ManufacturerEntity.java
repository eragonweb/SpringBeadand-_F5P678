package com.example.beadando.manufacturer.entity;

import com.example.beadando.core.entity.CoreEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "manufacturer")
@Entity
public class ManufacturerEntity extends CoreEntity {

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ManufacturerEntity() {
    }


}
