package com.careercompass.dao;

import com.careercompass.dao.entity.Job;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository  extends MongoRepository<Job,String> {

    @Query("{ \"qualification\":?0}")
    public List<Job> findByQualification(String stream);
}
