package com.careercompass.dao;

import com.careercompass.dao.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Query("{ \"email\":?0}")
    public User getUserEmail(String email);
}
