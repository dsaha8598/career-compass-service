package com.careercompass.services;

import com.careercompass.dao.UserRepository;
import com.careercompass.dao.entity.User;
import com.careercompass.model.requestbody.UserSignUpRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public User saveUserRegister(UserSignUpRequest userSignUpRequest) {
        if (userRepository.getUserEmail(userSignUpRequest.getEmail()) != null) {
            throw new RuntimeException("Email already present");
        }
        String encodedPassword = passwordEncoder.encode(userSignUpRequest.getPassword());
        System.out.println(passwordEncoder.matches("testpassword",encodedPassword));
        User user = new User();
        BeanUtils.copyProperties(userSignUpRequest, user);
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

}
