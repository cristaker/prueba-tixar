package com.ticxar.pruebaticxar.service.impl;

import com.ticxar.pruebaticxar.client.AuthClient;
import com.ticxar.pruebaticxar.models.dto.LoginRequestDto;
import com.ticxar.pruebaticxar.models.dto.LoginResponseDto;
import com.ticxar.pruebaticxar.models.dto.UserProfileDto;
import com.ticxar.pruebaticxar.models.entities.LoginLog;
import com.ticxar.pruebaticxar.repository.LoginLogRepository;
import com.ticxar.pruebaticxar.service.AuthService;
import com.ticxar.pruebaticxar.util.LoginLogMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthClient authClient;
    private final LoginLogRepository loginLogRepository;
    private final LoginLogMapper loginLogMapper;

    @Override
    public LoginResponseDto loginAndSave(LoginRequestDto request) {
        ResponseEntity<LoginResponseDto> response = authClient.login(request);
        LoginResponseDto loginResponse = response.getBody();
        if(loginResponse != null) {
            LoginLog log = loginLogMapper.toLoginLog(loginResponse);
            loginLogRepository.save(log);
        }
        return loginResponse;
    }

    public UserProfileDto getAuthenticatedUser(String token) {
        return authClient.getAuthenticatedUser("Bearer " + token).getBody();
    }
}

