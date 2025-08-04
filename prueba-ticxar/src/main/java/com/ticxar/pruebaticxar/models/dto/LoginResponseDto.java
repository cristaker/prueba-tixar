package com.ticxar.pruebaticxar.models.dto;

import lombok.Data;

@Data
public class LoginResponseDto {
    private int id;
    private String username;
    private String email;
    private String accessToken;
    private String refreshToken;
}

