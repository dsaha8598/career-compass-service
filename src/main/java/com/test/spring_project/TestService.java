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
    @Autowired
    private UserRepository userRepository;


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

    public List<UserResponse> findByName(String name) {

        List<UserResponse> n=uesrData.getAllUserResponse();
        ArrayList<UserResponse> nm= new ArrayList<>();

        for( UserResponse e :n){
            if(e.getName().equals(name)){
                nm.add(e);
            }

        }

         return n;
    }
//    public List<UserResponse> findByisMarried(boolean isMarried) {
//
//        List<UserResponse> b=uesrData.getAllUserResponse();
//        List<UserResponse> m = new ArrayList<>();
//        for(UserResponse mg = b){
//            if(m.getisMarried.equals(isMarried)){
//                m.add(mg);
//            }

//        }
//
//        return b;
//    }
public UserData saveAlldetails(String name,String email,String gender,Integer age,Long phone)
    {
          UserData user1=new UserData();
          user1.setName(name);
          user1.setEmail(email);
          user1.setAge(age);
          user1.setPhone(phone);
          user1.setGender(gender);

          return userRepository.save(user1);
}
public List<UserData> getGender(String gender){

          return userRepository.getUserbyGender(gender);
}

}
