package com.careercompass.service;

import com.careercompass.dao.JobRepository;
import com.careercompass.dao.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> getJobsByQualifiacation(String qualification){
        return jobRepository.findByQualification(qualification);
    }
}
