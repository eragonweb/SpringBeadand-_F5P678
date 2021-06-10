package com.example.beadando.core;

import com.example.beadando.manufacturer.entity.ManufacturerEntity;

import java.util.List;

public interface CoreCRUDService <T> {
    List<T> findAll();

    T create(T entity);

    boolean deteteById(Long id);

    T update(T entity);

    T findById(Long id);


}
