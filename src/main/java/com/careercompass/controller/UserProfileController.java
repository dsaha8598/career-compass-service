package com.careercompass.controller;

import com.careercompass.dao.QualificationRepository;
import com.careercompass.dao.entity.Qualification;
import com.careercompass.dao.entity.User;
import com.careercompass.service.UserQualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

import static com.careercompass.constants.CareerCompassConstants.USER_ROOT_URL;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/careerCompass/profile")
public class UserProfileController {

    @Autowired
    private UserQualificationService userQualificationService;

    @GetMapping("/getAll")
    public List<String> AllQualificationList(){

        return userQualificationService.getAllStream();
    }

    @GetMapping("/qualification/{stream}")
        public List<Qualification> QualificationList(@PathVariable String stream){

        List<Qualification> result=userQualificationService.userQualificationByName(stream);
        return result;
    }

   @PostMapping("/addQualification")
    public Set<String> saveQualificationtoUser(@RequestParam String email, @RequestParam String qualification){return userQualificationService.saveUserQualifiaction(email, qualification);
   }

    @PostMapping("/removeQualification")
    public Set<String> removeQualificationtoUser(@RequestParam String email, @RequestParam String qualification){return userQualificationService.removeUserQualifiaction(email, qualification);
    }

    @PostMapping("/addSkill")
    public Set<String> saveSkillUser(@RequestParam String email, @RequestParam String skill){return userQualificationService.saveUserskill(email, skill);
    }

    @PostMapping("/removeSkill")
    public Set<String> removeSkilltoUser(@RequestParam String email, @RequestParam String skill){return userQualificationService.removeUserSkill(email, skill);
    }


}
