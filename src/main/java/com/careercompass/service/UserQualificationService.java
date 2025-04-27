package com.careercompass.service;

import com.careercompass.dao.QualificationRepository;
import com.careercompass.dao.UserRepository;
import com.careercompass.dao.entity.Qualification;
import com.careercompass.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserQualificationService {
    @Autowired
    private QualificationRepository qualificationRepository;

    @Autowired
    private UserRepository userRepository;


    public List<String> getAllStream(){
         return qualificationRepository.findAll().stream().map(q->q.getStream()).distinct().toList();
    }

    public List<Qualification> userQualificationByName(String stream){
        List<Qualification> n=qualificationRepository.findByQualificationName(stream);
        return n;
    }

    public Set<String> saveUserQualifiaction(String email, String qualification){
      User user = userRepository.getUserByEmail(email, true);
      if(user.getQualifications() != null){
          user.getQualifications().add(qualification);
      } else {
          user.setQualifications(new HashSet<>(Arrays.asList(qualification)));
      }
      return userRepository.save(user).getQualifications();
    }

    public Set<String> removeUserQualifiaction(String email, String qualification){
        User user = userRepository.getUserByEmail(email, true);
        if(user.getQualifications() != null){
            user.getQualifications().remove(qualification);
        }
        return userRepository.save(user).getQualifications();
    }

    public Set<String> saveUserskill(String email, String skill){
        User user = userRepository.getUserByEmail(email, true);
        if(user.getSkills() != null){
            user.getSkills().add(skill);
        } else {
            user.setSkills(new HashSet<>(Arrays.asList(skill)));
        }
        return userRepository.save(user).getSkills();
    }

    public Set<String> removeUserSkill(String email, String skill){
        User user = userRepository.getUserByEmail(email, true);
        if(user.getSkills() != null){
            user.getSkills().remove(skill);
        }
        return userRepository.save(user).getSkills();
    }
}
