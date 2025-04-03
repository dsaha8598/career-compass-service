package com.test.spring_project;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controller {

   @Autowired
    private TestService testService;
   @Autowired
   private UserRepository userRepository;

    @GetMapping("/test1")
    public static String test1(){

        return "Hello World!";
    }
    //PathParam
    //PathVariable
    @GetMapping("PathParam/{number}/{name}")
    public String toCatachPathParam(@PathVariable Integer number,@PathVariable String name){
        String response= testService.m1(number,name);
        return response;
    }

    //queryparam
    //requestparam
     @GetMapping("/QueryParam")
    public String toCatchQueryParam(@RequestParam(name="name",required = false,defaultValue = "Default") String name,
                                    @RequestParam(name="age",required = false,defaultValue = "1") Integer age,
                                    @RequestParam(name="status",required = false,defaultValue = "false") boolean status){
                  String result= testService.m2(name,age,status);
        return result;
     }

     @PostMapping("/requestbody")
    public UserResponse toRequestBody(@RequestBody(required = false) UserResponse UserResponse ){

        return UserResponse ;
     }
   @GetMapping("/getAll")
     public List<UserResponse> getAllUserResponse(){

        return testService.getAll();
     }
    //Get Name from the url which is equalto Databasetest
    @GetMapping("/GetByName/{name}")
    public List<UserResponse> getByName(@PathVariable String name){

        return testService.findByName(name);

    }
//    @GetMapping("/getByNameAndMaritalStatus/{name}")
//    public List<UserResponse> getByName(@PathVariable String name, @RequestParam(name="isMarried") boolean isMarried){
//
//        return testService.findByNameandMarried(name,isMarried);
//
//    }
//    @GetMapping("/getbyisMarried/{isMarried}")
//    public List<UserResponse> findByisMarried(@PathVariable boolean isMarried){
//
//        return testService.findBygetMarried(isMarried);
//    }

    @GetMapping("/save")
    public UserData saveUserData(){
        UserData user=new UserData();
        user.setName("Jagadish Oram");
        user.setEmail("jagadish@gmail.com");
        user.setAge(21);

        return userRepository.save(user);
    }
    @GetMapping("/getAlluser")
    public List<UserData>  getAlldetails(){

        return userRepository.findAll();
    }

@GetMapping("/findbyId/{id}")
    public UserData getbyid(@PathVariable Integer id){

        return userRepository.findById(id).get();
}
@PostMapping("/savepostmapping")
    public UserData saveaspostmapping(@RequestBody UserData user){

        return userRepository.save(user);
}

@PostMapping("/save2")
    public UserData save2(@RequestBody UserData user12){

        return testService.saveAlldetails(user12.getName(),user12.getEmail(),user12.getGender(),user12.getAge(),user12.getPhone());
}
    @GetMapping("/genderby")
    public List<UserData> getgenderBy(@RequestParam String gender){
       List<UserData> result = testService.getGender(gender);
        return result;
    }

}
