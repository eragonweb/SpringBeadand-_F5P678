package com.example.beadando.user.config;
import com.example.beadando.user.entity.AppRoleEntity;
import com.example.beadando.user.entity.AppUserEntity;
import com.example.beadando.user.service.AppRoleService;
import com.example.beadando.user.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
@Configuration
public class AppUserInitConfig {
    @Autowired
    private AppRoleService appRoleService;
    @Autowired
    private AppUserService appUserService;

    @PostConstruct
    private void init() {
        //léterhozzok a demo szerepköreinket
        List<AppRoleEntity> roles = appRoleService.findAll();
        if (roles.isEmpty()) {
            AppRoleEntity admin = new AppRoleEntity();
            admin.setAuthority("ROLE_ADMIN");
            appRoleService.create(admin);
            roles.add(admin);

            AppRoleEntity user = new AppRoleEntity();
            user.setAuthority("ROLE_USER");
            appRoleService.create(user);
            roles.add(user);

        }
        //létrehozzuk a demo felhasználóinkat.
        List<AppUserEntity> users = appUserService.findAll();
        if (users.isEmpty()) {

            AppUserEntity adminEntity = new AppUserEntity();
            adminEntity.setUsername("admin");
            adminEntity.setPassword(new BCryptPasswordEncoder().encode("almafa123"));
            adminEntity.setAuthorities(new HashSet<>(roles));
            appUserService.create(adminEntity);

            AppUserEntity userEntity = new AppUserEntity();
            userEntity.setUsername("user");
            userEntity.setPassword(new BCryptPasswordEncoder().encode("almafa123"));
            AppRoleEntity userRole = roles.stream().filter(appRoleEntity -> appRoleEntity.getAuthority().equals("ROLE_USER")).findFirst().get();
            userEntity.setAuthorities(new HashSet<>(Collections.singletonList(userRole)));
            appUserService.create(userEntity);
        }
    }
}