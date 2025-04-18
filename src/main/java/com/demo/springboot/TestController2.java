package com.demo.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:3000")
@RestController()
@RequestMapping(value ="/flipkart")
public class TestController2 {

    /**
     * this is called autowiring / dependency injection
     * means spring boot will create one object of TestService and will store that object in variable testService.
     * @Autowired annotations give command to spring boot to scan for a class called TestService,
     * TestService can only be seen by spring boot if and only if TestService class is having annotation @Component or @Service
     */
    @Autowired
    private TestService testService;

    @Autowired
    private UserRepository userRepository;

    //pathvariable
    //pathparam
    @GetMapping("pathparam/{number}/{namePlaceHolder}")
    public String toCatchPathparam(@PathVariable Integer number, @PathVariable(name = "namePlaceHolder") String name){
        String response = testService.m1(number, name);
        return response;
    }

    //queryparam
    //requestparam
    @GetMapping("/queryparam")
    public String queryParamLearning(@RequestParam(name="name", required = false, defaultValue = "default") String name,
                                     @RequestParam(name="age", required = false, defaultValue = "1") Integer age,
                                     @RequestParam(name="active", required = false, defaultValue = "false") Boolean active){
        String response = testService.m2(name, age, active);
        return response;
    }


    @PostMapping("/requestbody")
    public RequestBodyTest requestBodyLearning(@RequestBody(required = false) RequestBodyTest requestBodyTest){
        return requestBodyTest;
    }

    @GetMapping("/getAll")
    public List<RequestBodyTest> getAllRequestBodies(){
        return testService.getAll();
    }

    @GetMapping("/save")
    public User saveUserDetails(){
        User user = new User();
        user.setAge(27);
        user.setEmail("xyz@gmail.com");
        user.setGender("Male");
        user.setName("Dipak");
        user.setPh(546879877l);
        return userRepository.save(user);

    }

    @GetMapping("/getUser")
    public List<User> getUserDetails(){
        return testService.getAllUser();

    }

   // http://localhost:8081/flipkart/user/2
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Integer id){
       return userRepository.findById(id).get();
    }

    @PostMapping("/save-version-2")
    public User saveUserDetails(@RequestBody UserRequestBody userRequestBody){
         User user = new User();
         user.setName(userRequestBody.getName());
         user.setPh(userRequestBody.getPh());
         user.setGender(userRequestBody.getGender());
         user.setEmail(userRequestBody.getEmail());
         user.setAge(userRequestBody.getAge());
        return userRepository.save(user);
    }

    @GetMapping("/getUserByGender")
    public List<User> getUserByGender(@RequestParam String gender, @RequestParam Integer age){
        List<User> list = testService.findListOfUsersByGender(gender, age);
        return list;
    }





}
