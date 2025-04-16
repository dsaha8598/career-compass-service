package com.careercompass.services;

import com.careercompass.dao.UserRepository;
import com.careercompass.dao.entity.User;
import com.careercompass.model.requestbody.UserSignUpRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


public User saveUserRegister(UserSignUpRequest userSignUpRequest){
    if (userRepository.getUserEmail(userSignUpRequest.getEmail())!=null)
    {
        throw new RuntimeException("Email already present");
    }
    User user = new User();
    BeanUtils.copyProperties(userSignUpRequest, user);


    return userRepository.save(user);
}

public String getEmailQualification(String email, String value){

    User q=userRepository.getUserEmail(email);
     if(q!=null){
         return q.getValue();

     }

    return "Email not found ";
}


}
