package dev.ztp.blogapp.be.auth;

import lombok.Data;

@Data
public class LoginDto {
    private String username;
    private String password;
}
