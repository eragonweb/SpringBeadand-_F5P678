package com.example.beadando.manufacturer.service;


import com.example.beadando.manufacturer.entity.ManufacturerEntity;

import java.util.List;

public interface ManufacturerService {
    List<ManufacturerEntity> findAll();


    ManufacturerEntity create(ManufacturerEntity entity);

    boolean deteteById(Long id);

    ManufacturerEntity update(ManufacturerEntity entity);

    ManufacturerEntity findById(Long id);
}
