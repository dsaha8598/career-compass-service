package com.test.spring_project;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataBaseTest {
    public List<UserResponse> getAllUserResponse(){
        List<UserResponse> UserResponseList;
        UserResponseList= Arrays.asList(
                new UserResponse("dipak", "1997", 27, false),
                new UserResponse("hemant", "2002", 23, true),
                new UserResponse("Abhay", "2001", 21, false),
                new UserResponse("Jagadish", "2002", 22, true),
                new UserResponse("Jagadish", "2004", 28, false),
                new UserResponse("Shradha", "2003", 20, true)
        );
        return UserResponseList;
    }




}

