package com.example.beadando.core.Impl;

import com.example.beadando.core.CoreCRUDService;
import com.example.beadando.core.CoreEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Transactional
public abstract class CoreCRUDServiceImpl<T extends CoreEntity> implements CoreCRUDService<T> {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<T> findAll() {
        //JPQL
        return entityManager.createQuery("SELECT a FROM " + getManagedClass().getSimpleName() + " a", getManagedClass()).getResultList();

    }

    @Override
    public T create(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public boolean deteteById(Long id) {
        T ManufacturerEntity = findById(id);
        if (ManufacturerEntity == null) {
            return false;

        }
        entityManager.remove(ManufacturerEntity);
        return false;
    }

    @Override
    public T update(T entity) {
        T updateCar = findById(entity.getId());
        if (updateCar != null) {
            updateCore(updateCar, entity);
            entityManager.merge(entity);
        }


        return updateCar;
    }

    @Override
    public T findById(Long id) {

        return entityManager.find(getManagedClass(), id);
    }

    protected abstract void updateCore(T updateEntity, T entity);

    protected abstract Class<T> getManagedClass();

}
