package com.careercompass.controller;

import com.careercompass.dao.QualificationRepository;
import com.careercompass.dao.entity.Qualification;
import com.careercompass.services.UserQualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.careercompass.constants.CareerCompassConstants.USER_ROOT_URL;

@RestController
@RequestMapping(USER_ROOT_URL)
public class UserProfileController {

    @Autowired
    private UserQualificationService userQualificationService;

    @GetMapping("/getAll")
    public List<String> AllQualificationList(){

        return userQualificationService.getAllStream();
    }

    @GetMapping("/listbyname/{stream}")
        public List<Qualification> QualificationList(@PathVariable String stream){

        List<Qualification> result=userQualificationService.userQualificationByName(stream);
        return result;
    }




}
