package com.careercompass.controller;

import com.careercompass.configurations.JWTService;
import com.careercompass.dao.UserRepository;
import com.careercompass.dao.entity.User;
import com.careercompass.model.requestbody.LoginRequest;
import com.careercompass.model.requestbody.UserSignUpRequest;
import com.careercompass.model.response.OtpValidationResponse;
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
    @Autowired
    private JWTService jwtService;

    @PostMapping("/register")
    public User registerUser(@RequestBody UserSignUpRequest userSignUpRequest) {
        User result = userService.saveUserRegister(userSignUpRequest);
        return result;
    }

    @GetMapping("/send/otp")
    public UserResponse sendOtp(@RequestParam String email, @RequestParam String pageSource) {
        System.out.println(email);
        return userService.sendOtp(email, pageSource);
    }

    @GetMapping("/validate/otp")
    public OtpValidationResponse registerUser(@RequestParam String email,@RequestParam String otp, @RequestParam String pageSource) {
        return userService.validateOtp(email, otp, pageSource);
    }

    @PostMapping("/update/password")
    public UserResponse updatePassword(@RequestParam String email,@RequestParam String password) {
        return userService.updatePassword(email, password);
    }

    @PostMapping("/login")
    public User updatePassword(@RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }

    @GetMapping()
    public String testSecurity(){
        return "able to access";
    }

    @GetMapping("/test2")
    public String testSecurity2(){
        return "able to access";
    }

    @GetMapping("/token")
    public String generateToken(@RequestParam String email, @RequestParam String password){
        return userService.generateToken(email, password);
    }

    @GetMapping("/details")
    public User getuserdata(@RequestHeader(name = "Authorization") String authToken){
       return userService.getUserDetails(authToken);
    }




}
