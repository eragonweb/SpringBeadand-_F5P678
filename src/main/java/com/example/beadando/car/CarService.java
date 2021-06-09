package com.example.beadando.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CarService {
    @Autowired
    private EntityManager entityManager;
    //TODO nem best practice
    private List<CarEntity> list = new ArrayList<>();

    public CarService() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CarEntity entity = new CarEntity();
            entity.setID(Long.parseLong(i + ""));
            entity.setType("Pickup" + i);
            entity.setDoor_number(5);
            entity.setManufacturer("Ford");
            entity.setManufacturer_year(2009 + i);
            list.add(entity);
        }
    }

    public List<CarEntity> findAll() {
        //JPQL
        return entityManager.createQuery("SELECT a FROM CarEntity a", CarEntity.class).getResultList();

    }

    public CarEntity create(CarEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public boolean deteteById(Long id) {
        for (CarEntity entity : list) {
            if (entity.getID().equals(id)) {
                list.remove(entity);
                return true;
            }
        }
        return false;
    }

    public CarEntity update(CarEntity entity) {
        CarEntity updateCar = findCarById(entity.getID());
        if (updateCar != null) {
            updateCar.setType(entity.getType());
            updateCar.setDoor_number(entity.getDoor_number());
            updateCar.setManufacturer(entity.getManufacturer());
            updateCar.setManufacturer_year(entity.getManufacturer_year());
        }


        return updateCar;
    }

    public CarEntity findCarById(Long id) {
        for (CarEntity entity : list) {
            if (entity.getID().equals(id)) {
                return entity;
            }

        }
        return null;
    }

}

