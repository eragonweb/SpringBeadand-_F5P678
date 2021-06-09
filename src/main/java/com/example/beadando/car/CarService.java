package com.example.beadando.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CarService {
    @Autowired
    private EntityManager entityManager;


    public CarService() {
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
      CarEntity ManufacturerEntity= findById(id);
      if(ManufacturerEntity==null){
          return false;

      }
      entityManager.remove(ManufacturerEntity);
        return false;
    }

    public CarEntity update(CarEntity entity) {
        CarEntity updateCar = findById(entity.getID());
        if (updateCar != null) {
            updateCar.setType(entity.getType());
            updateCar.setDoor_number(entity.getDoor_number());
            updateCar.setManufacturer(entity.getManufacturer());
            updateCar.setManufacturer_year(entity.getManufacturer_year());
            entityManager.merge(entity);
        }


        return updateCar;
    }

    public CarEntity findById(Long id) {

        return entityManager.find(CarEntity.class, id);
    }

}

