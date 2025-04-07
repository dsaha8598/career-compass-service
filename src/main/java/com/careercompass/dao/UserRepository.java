package com.careercompass.dao;

import com.careercompass.dao.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Query("{ \"email\":?0,\"emailVerified\":?1}")
    public User getUserByEmail(String email, boolean emailVerified);
}
