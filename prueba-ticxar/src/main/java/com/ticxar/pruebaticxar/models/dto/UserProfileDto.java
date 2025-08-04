package com.ticxar.pruebaticxar.models.dto;

import lombok.Data;

@Data
public class UserProfileDto {
    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String image;
    private String role;
}
