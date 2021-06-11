package com.example.beadando.manufacturer.service.Impl;

import com.example.beadando.core.Impl.CoreCRUDServiceImpl;
import com.example.beadando.manufacturer.entity.ManufacturerEntity;
import com.example.beadando.manufacturer.service.ManufacturerService;
import org.springframework.stereotype.Service;

@Service

public class ManufacturerServiceImpl extends CoreCRUDServiceImpl<ManufacturerEntity> implements ManufacturerService {

    @Override
    protected void updateCore(ManufacturerEntity updateEntity, ManufacturerEntity entity) {
        updateEntity.setName(entity.getName());
    }

    @Override
    protected Class<ManufacturerEntity> getManagedClass() {
        return ManufacturerEntity.class;
    }
}

