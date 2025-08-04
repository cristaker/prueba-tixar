package com.ticxar.pruebaticxar.service.impl;

import com.ticxar.pruebaticxar.client.AuthClient;
import com.ticxar.pruebaticxar.models.dto.LoginRequestDto;
import com.ticxar.pruebaticxar.models.dto.LoginResponseDto;
import com.ticxar.pruebaticxar.models.dto.UserProfileDto;
import com.ticxar.pruebaticxar.models.entities.LoginLog;
import com.ticxar.pruebaticxar.repository.LoginLogRepository;
import com.ticxar.pruebaticxar.util.LoginLogMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthServiceImplTest {

    @Mock
    private AuthClient authClient;

    @Mock
    private LoginLogRepository loginLogRepository;

    @InjectMocks
    private AuthServiceImpl authService;

    @Mock
    private LoginLogMapper loginLogMapper;

    @Test
    void loginAndSave_deberiaRetornarLoginResponseYGuardarLog() {
        LoginRequestDto request = new LoginRequestDto();
        request.setUsername("michaelw");
        request.setPassword("123456");
        LoginResponseDto responseDto = new LoginResponseDto();
        responseDto.setUsername("michaelw");
        responseDto.setAccessToken("access-token");
        responseDto.setRefreshToken("refresh-token");
        LoginLog loginLogMock = new LoginLog();
        loginLogMock.setUsername("michaelw");
        when(authClient.login(any(LoginRequestDto.class)))
                .thenReturn(new ResponseEntity<>(responseDto, HttpStatus.OK));
        when(loginLogMapper.toLoginLog(responseDto)).thenReturn(loginLogMock);
        LoginResponseDto resultado = authService.loginAndSave(request);
        assertNotNull(resultado);
        assertEquals("michaelw", resultado.getUsername());
        assertEquals("access-token", resultado.getAccessToken());
        assertEquals("refresh-token", resultado.getRefreshToken());
        verify(loginLogMapper).toLoginLog(responseDto);
        verify(loginLogRepository).save(loginLogMock);
    }

    @Test
    void getAuthenticatedUser_deberiaRetornarPerfilDeUsuario() {
        String token = "token123";
        UserProfileDto mockUser = new UserProfileDto();
        mockUser.setId(2L);
        mockUser.setUsername("michaelw");
        mockUser.setEmail("michael.williams@x.dummyjson.com");
        when(authClient.getAuthenticatedUser("Bearer " + token))
                .thenReturn(new ResponseEntity<>(mockUser, HttpStatus.OK));
        UserProfileDto resultado = authService.getAuthenticatedUser(token);
        assertNotNull(resultado);
        assertEquals("michaelw", resultado.getUsername());
        assertEquals("michael.williams@x.dummyjson.com", resultado.getEmail());
        assertEquals(2L, resultado.getId());
    }
}

