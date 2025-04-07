package com.careercompass.configurations;

import com.careercompass.dao.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserSecurityRepo extends MongoRepository<User, String> {

    @Query("{ \"email\":?0,\"emailVerified\":?1}")
    public User getUserByEmail(String email, boolean emailVerified);
}
