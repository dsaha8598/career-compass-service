package com.test.spring_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
//@Component
public class TestService {
    @Autowired
    private DataBaseTest uesrData;


      public String m1(Integer num,String name){
              System.out.print(num+name);
         return "Number is "+num +"Name is "+name;
      }
         public String m2(String name,Integer age,boolean status)
          {

             return "m2 method print"+name+" -"+age+"-"+status;
          }


     //GetAll Value From UserResponse
    public List<UserResponse> getAll(){

        return uesrData.getAllUserResponse();
    }

    public List<UserResponse> getByName(String name) {

        List<UserResponse> n=uesrData.getAllUserResponse().stream()
                .filter(user -> user.getName().equalsIgnoreCase(name)).distinct().toList();
         return n;
    }



}
