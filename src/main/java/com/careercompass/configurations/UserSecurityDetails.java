package com.careercompass.configurations;

import com.careercompass.dao.UserRepository;
import com.careercompass.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityDetails implements UserDetailsService {

    @Autowired
    private UserSecurityRepo userSecurityRepo;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        User user = userSecurityRepo.getUserByEmail(userEmail, true);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
