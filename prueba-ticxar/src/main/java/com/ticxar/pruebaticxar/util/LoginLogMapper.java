package com.ticxar.pruebaticxar.util;

import com.ticxar.pruebaticxar.models.dto.LoginResponseDto;
import com.ticxar.pruebaticxar.models.entities.LoginLog;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LoginLogMapper {

    public LoginLog toLoginLog(LoginResponseDto dto) {
        LoginLog log = new LoginLog();
        log.setUsername(dto.getUsername());
        log.setLoginTime(LocalDateTime.now());
        log.setAccessToken(dto.getAccessToken());
        log.setRefreshToken(dto.getRefreshToken());
        return log;
    }
}
