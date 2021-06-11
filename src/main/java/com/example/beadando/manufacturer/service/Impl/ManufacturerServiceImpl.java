package com.example.beadando.manufacturer.service.Impl;

import com.example.beadando.manufacturer.entity.ManufacturerEntity;
import com.example.beadando.manufacturer.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ManufacturerServiceImpl implements ManufacturerService {
    @Autowired
    private EntityManager entityManager;


    public ManufacturerServiceImpl() {

    }
    @Override
    public List<ManufacturerEntity> findAll() {
        //JPQL
        return entityManager.createQuery("SELECT a FROM ManufacturerEntity a", ManufacturerEntity.class).getResultList();

    }
    @Override
    public ManufacturerEntity create(ManufacturerEntity entity) {
        entityManager.persist(entity);
        return entity;
    }
    @Override
    public boolean deteteById(Long id) {
        ManufacturerEntity manufacturerEntity =findById(id);
        if(manufacturerEntity== null){
            return false;
        }
       entityManager.remove(manufacturerEntity);
        return false;
    }
    @Override
    public ManufacturerEntity update(ManufacturerEntity entity) {
        ManufacturerEntity updateManufacture = findById(entity.getId());
        if (updateManufacture != null) {
            updateManufacture.setName(entity.getName());
            entityManager.merge(updateManufacture);
        }


        return updateManufacture;
    }
    @Override
    public ManufacturerEntity findById(Long id) {
       return entityManager.find(ManufacturerEntity.class, id);
    }

}
