package com.careercompass.controller;

import com.careercompass.dao.entity.Job;
import com.careercompass.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.careercompass.constants.CareerCompassConstants.JOB_ROOT_URL;

@RestController
@RequestMapping(JOB_ROOT_URL)
public class JobController {
    @Autowired
    private JobService jobService;
    @GetMapping("/jobs/{qualification}")
    public List<Job> getJobsByQualification(@RequestHeader(name = "Authorization") String authToken, @PathVariable String qualification){
       return jobService.getJobsByQualifiacation(qualification) ;
    }
}
