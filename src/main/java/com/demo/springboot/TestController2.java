package com.demo.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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




}
