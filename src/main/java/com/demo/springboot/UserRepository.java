package com.demo.springboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "SELECT * FROM \"user-details\" where gender = ?1 and user_age=?2", nativeQuery = true)
    public List<User> getUserByGender(String gender, Integer age);

}
