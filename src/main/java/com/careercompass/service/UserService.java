package com.careercompass.service;

import com.careercompass.dao.UserRepository;
import com.careercompass.dao.entity.User;
import com.careercompass.model.requestbody.UserSignUpRequest;
import com.careercompass.model.response.UserResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OtpService otpService;

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

    public UserResponse sendOtp(String email){
        String response="";
        if(email != null && !StringUtils.isEmpty(email)){
            User user = userRepository.getUserEmail(email);
            if(user != null){
                response = otpService.sendOtp(email);
            } else {
                response = "This email is not registered with us";
            }
        }
        return new UserResponse(response);
    }

    public UserResponse validateOtp(String email, String otp){
        return new UserResponse(otpService.validateOtp(email, otp));
    }

}
