package com.careercompass.dao.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;

import static com.careercompass.constants.CareerCompassConstants.USER_COLLECTION;
@Service
@Component
@Data
@Document(collection = USER_COLLECTION)
public class User implements Serializable {

    @Id
    private String userId;
    private String email;
    private String name;
    private String password;
    private Long phoneNumber;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
