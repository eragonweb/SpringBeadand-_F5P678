package com.example.beadando.manufacturer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ManufacturerService {
    @Autowired
    private EntityManager entityManager;


    public ManufacturerService() {

    }

    public List<ManufacturerEntity> findAll() {
        //JPQL
        return entityManager.createQuery("SELECT a FROM ManufacturerEntity a", ManufacturerEntity.class).getResultList();

    }

    public ManufacturerEntity create(ManufacturerEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public boolean deteteById(Long id) {
        ManufacturerEntity manufacturerEntity =findById(id);
        if(manufacturerEntity== null){
            return false;
        }
       entityManager.remove(manufacturerEntity);
        return false;
    }

    public ManufacturerEntity update(ManufacturerEntity entity) {
        ManufacturerEntity updateManufacture = findById(entity.getId());
        if (updateManufacture != null) {
            updateManufacture.setName(entity.getName());
            entityManager.merge(updateManufacture);
        }


        return updateManufacture;
    }

    public ManufacturerEntity findById(Long id) {
       return entityManager.find(ManufacturerEntity.class, id);
    }

}

