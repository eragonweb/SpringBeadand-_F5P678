package com.example.beadando.user.service;

import com.example.beadando.core.CoreCRUDService;
import com.example.beadando.user.entity.AppUserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;


public interface AppUserService extends CoreCRUDService<AppUserEntity>, UserDetailsService {
    @Override
    List<AppUserEntity> findAll();

    @Override
    AppUserEntity create(AppUserEntity entity);

    @Override
    boolean deleteById(Long id);

    @Override
    boolean deteteById(Long id);

    @Override
    AppUserEntity update(AppUserEntity entity);

    @Override
    AppUserEntity findById(Long id);

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
