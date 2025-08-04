package com.ticxar.pruebaticxar.service;

import com.ticxar.pruebaticxar.models.dto.LoginRequestDto;
import com.ticxar.pruebaticxar.models.dto.LoginResponseDto;
import com.ticxar.pruebaticxar.models.dto.UserProfileDto;

public interface AuthService {
    LoginResponseDto loginAndSave(LoginRequestDto request);
    UserProfileDto getAuthenticatedUser(String token);
}
