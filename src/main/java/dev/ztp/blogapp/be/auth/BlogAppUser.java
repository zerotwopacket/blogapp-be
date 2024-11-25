package dev.ztp.blogapp.be.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class BlogAppUser implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "$2a$10$2RfD3htNV/K5gpI.jYlnIe/z4wxkClnQO6VFpSfE8gsIlTdwgLUbC";
    }

    @Override
    public String getUsername() {
        return "admin";
    }
}
