package com.test.spring_project;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

@RestController
public class controller {

    @GetMapping("/test1")
    public static String test1(){

        return "Hello World!";
    }
    //PathParam
    //PathVariable
    @GetMapping("pathparam/{number}/{name}")
    public String toCatachPathParam(@PathVariable Integer number,@PathVariable String name){
        return number+"-"+name;
    }

    //queryparam
    //requestparam
     @GetMapping("/queryparam")
    public String toCatchQueryParam(@RequestParam(name="name",required = false,defaultValue = "Default") String name,
                                    @RequestParam(name="age",required = false,defaultValue = "1") Integer age,
                                    @RequestParam(name="status",required = false,defaultValue = "false") boolean status){

        return name+"-"+age+"-"+status;
     }

     @PostMapping("/RequestBody")
    public UserResponse requestBody(@RequestBody(required = false) UserResponse UserResponse ){

        return UserResponse ;
     }


}
