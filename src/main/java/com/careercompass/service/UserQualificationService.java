package com.careercompass.service;

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


    public List<String> getAllStream(){
         List<Qualification> result=qualificationRepository.findAll();
         List<String> q=new ArrayList<>();
           result.forEach(qualification -> {
                q.add(qualification.getStream());
           });
        return q ;
    }

    public List<Qualification> userQualificationByName(String stream){
        List<Qualification> n=qualificationRepository.findByQualificationName(stream);
        return n;
    }
}
