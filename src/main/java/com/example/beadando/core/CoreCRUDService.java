package com.example.beadando.core;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CoreCRUDService<T> {
    List<T> findAll();

    @Transactional
    T create(T entity);

    @Transactional
    boolean deleteById(Long id);

    @Transactional
    T update(T entity);

    T findById(Long id);


}
