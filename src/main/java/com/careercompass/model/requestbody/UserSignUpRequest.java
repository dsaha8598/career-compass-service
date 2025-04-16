package com.careercompass.model.requestbody;

import lombok.Data;

@Data
public class UserSignUpRequest {
    private String email;
    private String name;
    private String password;
    private Long phone;
    private String value ="qualification";


}
