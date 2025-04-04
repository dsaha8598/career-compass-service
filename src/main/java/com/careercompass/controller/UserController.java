package com.careercompass.controller;

import com.careercompass.Services.UserService;
import com.careercompass.dao.UserRepository;
import com.careercompass.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.careercompass.constants.CareerCompassConstants.USER_ROOT_URL;

@RestController
@RequestMapping(USER_ROOT_URL)
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @GetMapping("/save")
    public User saveUser(){
        System.out.println("************************************");
       return userRepository.getuserbyemail("abc@gmail.com");
    }
    @Autowired
    private User user;
    @PostMapping("/login")
    public String loginUser(@RequestBody User user){

        return userService.userlogin(user.getEmail(), user.getPassword());
    }
}
