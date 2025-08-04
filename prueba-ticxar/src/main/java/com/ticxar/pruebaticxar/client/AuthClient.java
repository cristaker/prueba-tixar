package com.ticxar.pruebaticxar.client;

import com.ticxar.pruebaticxar.models.dto.LoginRequestDto;
import com.ticxar.pruebaticxar.models.dto.LoginResponseDto;
import com.ticxar.pruebaticxar.models.dto.UserProfileDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "authClient", url = "https://dummyjson.com")
@Service
public interface AuthClient {

    @PostMapping(value = "/auth/login", consumes = "application/json")
    ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto request);

    @GetMapping("/auth/me")
    ResponseEntity<UserProfileDto> getAuthenticatedUser(@RequestHeader("Authorization") String token);
}

