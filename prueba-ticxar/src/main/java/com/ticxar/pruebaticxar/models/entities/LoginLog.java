package com.ticxar.pruebaticxar.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "login_log")
public class LoginLog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String username;
    @Column(name = "login_time")
    private LocalDateTime loginTime;
    @Column(name = "access_token", columnDefinition = "TEXT")
    private String accessToken;
    @Column(name = "refresh_token", columnDefinition = "TEXT")
    private String refreshToken;
}

