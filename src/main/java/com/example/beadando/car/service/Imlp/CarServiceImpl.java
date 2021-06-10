package com.example.beadando.car.service.Imlp;

import com.example.beadando.car.entity.CarEntity;
import com.example.beadando.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired
    private EntityManager entityManager;


    public CarServiceImpl() {
          }
    @Override
    public List<CarEntity> findAll() {
        //JPQL
        return entityManager.createQuery("SELECT a FROM CarEntity a", CarEntity.class).getResultList();

    }
    @Override
    public CarEntity create(CarEntity entity) {
        entityManager.persist(entity);
        return entity;
    }
    @Override
    public boolean deteteById(Long id) {
      CarEntity ManufacturerEntity= findById(id);
      if(ManufacturerEntity==null){
          return false;

      }
      entityManager.remove(ManufacturerEntity);
        return false;
    }
    @Override
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
    @Override
    public CarEntity findById(Long id) {

        return entityManager.find(CarEntity.class, id);
    }

}

