package com.careercompass.services;

import com.careercompass.dao.UserRepository;
import com.careercompass.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


public User saveUserRegister(String name,String email,Long phone,String password){
    if (userRepository.getUserEmail(email) != null) {

        return null;
    }
  User saveAll=new User();
  saveAll.setName(name);
  saveAll.setEmail(email);
  saveAll.setPhone(phone);
  saveAll.setPassword(password);


return userRepository.save(saveAll);
}
public User userlogin(String email,String password){
    User v=userRepository.getUserEmail(email);
    if(v==null || !v.getPassword().equals(password)){

        return null;
    }

    return v;
}


}
