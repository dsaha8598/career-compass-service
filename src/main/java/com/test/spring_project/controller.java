package com.test.spring_project;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controller {

   @Autowired
    private TestService testService;

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

        return testService.getByName(name);

    }

}
