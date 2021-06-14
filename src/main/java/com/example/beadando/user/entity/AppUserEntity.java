package com.example.beadando.user.entity;

import com.example.beadando.core.entity.CoreEntity;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
@NamedQuery(name = AppUserEntity.FIND_USER_BY_USER_NAME, query = "select n from AppUserEntity n where n.username=:username")
@Entity
@Table(name = "app_user")
public class AppUserEntity extends CoreEntity implements UserDetails {

    public static final String FIND_USER_BY_USER_NAME = "AppUserEntity.findUserByUsername";

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<AppRoleEntity> authorities;

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Set<AppRoleEntity> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<AppRoleEntity> authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
