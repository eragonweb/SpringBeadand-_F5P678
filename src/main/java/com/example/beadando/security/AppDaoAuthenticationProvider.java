package com.example.beadando.security;
import com.example.beadando.user.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component

public class AppDaoAuthenticationProvider extends DaoAuthenticationProvider {
    @Autowired
    private AppUserService userService;

    public AppDaoAuthenticationProvider() {
        setPasswordEncoder(new BCryptPasswordEncoder());

    }

    @Autowired
    public void setUserDetailsService(@Qualifier("appUserServiceImpl") UserDetailsService userDetailsService) {
        super.setUserDetailsService(userService);
    }
}
