package com.careercompass.Services;

import com.careercompass.dao.UserRepository;
import com.careercompass.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
   public String userlogin(String email,String password) {
       User us= userRepository.getuserbyemail(email);
       if(us==null){
           return "user not found";
       }
       if(!us.getPassword().equals(password)){
           return "Wrong Password";
       }
       return "Login Successful";
   }
}
