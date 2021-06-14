package com.example.beadando.user.service.impl;

import com.example.beadando.core.impl.CoreCRUDServiceImpl;
import com.example.beadando.user.entity.AppRoleEntity;
import com.example.beadando.user.service.AppRoleService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class AppRoleServiceImpl extends CoreCRUDServiceImpl<AppRoleEntity> implements AppRoleService {
    @Override
    protected void updateCore(AppRoleEntity updatableEntity, AppRoleEntity entity) {
        updatableEntity.setAuthority(entity.getAuthority());
    }

    @Override
    protected Class<AppRoleEntity> getManagedClass() {
        return AppRoleEntity.class;
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
