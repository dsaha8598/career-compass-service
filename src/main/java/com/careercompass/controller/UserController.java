package com.careercompass.controller;

import com.careercompass.dao.UserRepository;
import com.careercompass.dao.entity.User;
import com.careercompass.model.requestbody.UserSignUpRequest;
import com.careercompass.model.response.UserResponse;
import com.careercompass.service.OtpService;
import com.careercompass.service.UserService;
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
    public User saveUser() {
        return userRepository.getUserEmail("abc@gmail.com");
    }

    @GetMapping("/send/otp")
    public UserResponse sendOtp(@RequestParam String email) {
        System.out.println(email);
        return userService.sendOtp(email);
    }

    @GetMapping("/validate/otp/{otp}/{email}")
    public UserResponse sendOtp(@PathVariable String otp, @PathVariable String email) {
        return userService.validateOtp(email, otp);
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody UserSignUpRequest userSignUpRequest) {
        User result = userService.saveUserRegister(userSignUpRequest);
        return result;
    }


}
