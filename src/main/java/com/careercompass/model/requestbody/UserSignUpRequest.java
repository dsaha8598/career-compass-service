package com.careercompass.model.requestbody;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserSignUpRequest {
    private String email;
    private String name;
    private String password;
    private Long phone;
    private String gender;
    private LocalDate dateOfBirth;
}
