package dev.ztp.blogapp.be.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRepository {

    public UserDetails findByUsername(String username) {
        if("admin".equals(username)) {
            return new BlogAppUser();
        }
        throw new RuntimeException("User not found");

    }
}
