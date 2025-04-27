package com.careercompass.dao.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static com.careercompass.constants.CareerCompassConstants.USER_COLLECTION;

@Data
@Document(collection = USER_COLLECTION)
public class User implements Serializable, UserDetails {

    @Id
    private String userId;
    private String email;
    private String name;
    private LocalDate dateOfBirth;
    private String password;
    private Long phone;
    private String gender;
    private Boolean emailVerified;
    private Set<String> qualifications;
    private Set<String> skills;
    @Transient
    private String token;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return "";
    }
}
