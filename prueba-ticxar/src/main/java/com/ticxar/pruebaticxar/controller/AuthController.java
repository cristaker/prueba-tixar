package com.ticxar.pruebaticxar.controller;

import com.ticxar.pruebaticxar.models.dto.LoginRequestDto;
import com.ticxar.pruebaticxar.models.dto.LoginResponseDto;
import com.ticxar.pruebaticxar.models.dto.UserProfileDto;
import com.ticxar.pruebaticxar.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto request) {
        LoginResponseDto response = authService.loginAndSave(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileDto> getMe(@RequestHeader("Authorization") String token) {
        UserProfileDto user = authService.getAuthenticatedUser(token);
        return ResponseEntity.ok(user);
    }
}
