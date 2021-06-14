package com.example.beadando.car.service.Imlp;

import com.example.beadando.car.entity.CarEntity;
import com.example.beadando.car.service.CarService;
import com.example.beadando.core.impl.CoreCRUDServiceImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl extends CoreCRUDServiceImpl<CarEntity> implements CarService {


    @Override
    protected void updateCore(CarEntity updateEntity, CarEntity entity) {
        updateEntity.setManufacturer(entity.getManufacturer());
        updateEntity.setDoor_number(entity.getDoor_number());
        updateEntity.setManufacturer_year(entity.getManufacturer_year());
        updateEntity.setType(entity.getType());


    }

    @Override
    protected Class<CarEntity> getManagedClass() {
        return CarEntity.class;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }


    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}

