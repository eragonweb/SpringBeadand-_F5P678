package com.example.beadando.car.service;

import com.example.beadando.car.entity.CarEntity;

import java.util.List;

public interface CarService {
    List<CarEntity> findAll();

    CarEntity create(CarEntity entity);

    boolean deteteById(Long id);

    CarEntity update(CarEntity entity);

    CarEntity findById(Long id);
}
