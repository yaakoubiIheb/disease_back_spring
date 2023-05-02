package com.example.disease_backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserLoginDto {

    private String username;
    private String password;
}
