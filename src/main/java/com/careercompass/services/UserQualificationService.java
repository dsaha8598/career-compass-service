package com.careercompass.services;

import com.careercompass.dao.QualificationRepository;
import com.careercompass.dao.entity.Qualification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserQualificationService {
    @Autowired
    private QualificationRepository qualificationRepository;


    public List<Qualification> getAllStream(){
        return qualificationRepository.findAll();
    }

    public List<Qualification> UserQualificationByName(String stream){
        List<Qualification> n=qualificationRepository.findByQualificationName(stream);
        ArrayList<Qualification> nm=new ArrayList<>();
        for(Qualification q:n){
            if(q.getStream().equals(stream)){
                nm.add(q);
            }
        }
        return n;
    }
}
