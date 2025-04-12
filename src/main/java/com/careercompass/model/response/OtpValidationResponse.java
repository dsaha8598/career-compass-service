package com.careercompass.model.response;

import com.careercompass.dao.entity.User;
import lombok.Data;

@Data
public class OtpValidationResponse {

    private String message;
    private User user;
}
