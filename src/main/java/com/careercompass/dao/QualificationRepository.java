package com.careercompass.dao;

import com.careercompass.dao.entity.Qualification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.List;


@Component
@Repository
public interface QualificationRepository extends MongoRepository<Qualification,String> {

    @Query ("{ \"stream\":?0}")
   public List<Qualification> findByQualificationName(String stream);


}
