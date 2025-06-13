package com.example.Ekart.Entity;

import lombok.Data;

import java.util.Set;

@Data
public class UserResponseDto {
    private String username;
    private String email;
    private Set<String> role;

    public UserResponseDto(String username, String email, Set<String> role) {
        this.username = username;
        this.email = email;
        this.role = role;
    }

    // Getters and setters (or use Lombok)
}