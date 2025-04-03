package com.careercompass.dao.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

import static com.careercompass.constants.CareerCompassConstants.USER_COLLECTION;

@Data
@Document(collection = USER_COLLECTION)
public class User implements Serializable {

    @Id
    private String userId;
    private String email;
    private String name;
    private String password;
    private Long phoneNumber;
}
