package com.test.spring_project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public interface UserRepository extends JpaRepository<UserData,Integer> {
    @Query(value = "SELECT * FROM \"UESR_DETAILS\" where gender=?1",nativeQuery = true)
    public List<UserData> getUserbyGender(String gender);
}
