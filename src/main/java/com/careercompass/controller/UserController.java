package com.careercompass.controller;

import com.careercompass.dao.UserRepository;
import com.careercompass.dao.entity.User;
import com.careercompass.model.requestbody.UserSignUpRequest;
import com.careercompass.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import static com.careercompass.constants.CareerCompassConstants.USER_ROOT_URL;

@RestController
@RequestMapping(USER_ROOT_URL)
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/save")
    public User saveUser(){
       return userRepository.getUserEmail("abc@gmail.com");
    }

@PostMapping("/register")
public User registerUser(@RequestBody UserSignUpRequest userSignUpRequest) {

    User result = userService.saveUserRegister(userSignUpRequest);

    return result;
 }

 @GetMapping("/userQualification")
        public String userQualification(@RequestParam String email,@RequestParam String value){


     return userService.getEmailQualification(email,value);
 }

}
