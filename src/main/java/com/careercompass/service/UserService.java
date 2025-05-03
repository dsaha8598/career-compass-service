package com.careercompass.service;

import com.careercompass.configurations.JWTService;
import com.careercompass.dao.UserRepository;
import com.careercompass.dao.entity.User;
import com.careercompass.model.requestbody.LoginRequest;
import com.careercompass.model.requestbody.UserSignUpRequest;
import com.careercompass.model.response.OtpValidationResponse;
import com.careercompass.model.response.UserResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import static com.careercompass.constants.CareerCompassConstants.OTP_VALIDATED;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OtpService otpService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JWTService jwtService;

    public User saveUserRegister(UserSignUpRequest userSignUpRequest) {
        User user = new User();
        if (userRepository.getUserByEmail(userSignUpRequest.getEmail(), true) != null) {
            user.setError("Email is associated with other account");
            return user;
        }
        String encodedPassword = passwordEncoder.encode(userSignUpRequest.getPassword());

        BeanUtils.copyProperties(userSignUpRequest, user);
        user.setEmail(userSignUpRequest.getEmail().toLowerCase());
        user.setPassword(encodedPassword);
        user.setEmailVerified(false);
        otpService.sendOtp(user.getEmail());
        return userRepository.save(user);
    }

    public UserResponse sendOtp(String email, String pageSource){
        String response="";
        if(email != null && !StringUtils.isEmpty(email)){
            User user = userRepository.getUserByEmail(email,"signUp".equalsIgnoreCase(pageSource) ? false : true );
            if(user != null){
                response = otpService.sendOtp(email);
            } else {
                response = "This email is not registered with us";
            }
        }
        return new UserResponse(response);
    }

   public OtpValidationResponse validateOtp(String email, String otp,  String pageSource){
        String validationMessage = otpService.validateOtp(email, otp);
       OtpValidationResponse otpValidationResponse = new OtpValidationResponse();
        if(OTP_VALIDATED.equalsIgnoreCase(validationMessage)){
            User user = userRepository.getUserByEmail(email, "signUp".equalsIgnoreCase(pageSource) ? false : true);
            user.setEmailVerified(true);
            user = userRepository.save(user);
            user.setToken(jwtService.generateToken(user));
            otpValidationResponse.setUser(user);
        } else {
            otpValidationResponse.setMessage(validationMessage);
        }
        return otpValidationResponse;
   }

    public UserResponse updatePassword(String email, String passWord){
        String response = "";
       try {
           if (email != null && !StringUtils.isEmpty(email)) {
               User user = userRepository.getUserByEmail(email, true);
               if (user != null) {
                   user.setPassword(passwordEncoder.encode(passWord));
                   userRepository.save(user);
                   response = "Password Updated Successfully, login to continue";
               } else {
                   response = "Failed to Update Password";
               }
           }
       }catch(Exception e){
           response = "Failed to Update Password";
       }
        return new UserResponse(response);
    }

    public User login(LoginRequest loginRequest){
        User user = userRepository.getUserByEmail(loginRequest.getEmail().toLowerCase(), true);
        if(user != null
                && user.getPassword() != null
                && passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
            String token = jwtService.generateToken(user);
            user.setToken(token);
            return user;
        } else {
           throw new RuntimeException("Invalid credentials");
        }
    }

    public String generateToken(String email, String password){
        Authentication authentication = authenticationProvider.authenticate(
                new UsernamePasswordAuthenticationToken(email, password));

        User user = (User) authentication.getPrincipal();
        return jwtService.generateToken(user);
    }

    public User getUserDetails(String token){
        String userEmail = jwtService.extractUsername(token);
        User user = userRepository.getUserByEmail(userEmail, true);
        user.setToken(token);
        return user;
    }


}
