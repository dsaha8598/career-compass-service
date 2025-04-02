package com.careercompass.controller;

import com.careercompass.dao.UserRepository;
import com.careercompass.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.careercompass.constants.CareerCompassConstants.USER_ROOT_URL;

@RestController
@RequestMapping(USER_ROOT_URL)
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public User saveUser(){
        User user = new User();
        user.setUserId("15485-dipak");
        return userRepository.save(user);
    }
}
