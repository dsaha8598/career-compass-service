package com.demo.springboot;

import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value ="/flipkart")
public class TestController2 {

    //pathvariable
    //pathparam
    @GetMapping("pathparam/{number}/{namePlaceHolder}")
    public String toCatchPathparam(@PathVariable Integer number, @PathVariable(name = "namePlaceHolder") String name){
        return number + " - "+name;
    }

    //queryparam
    //requestparam
    @GetMapping("/queryparam")
    public String queryParamLearning(@RequestParam(name="name", required = false, defaultValue = "default") String name,
                                     @RequestParam(name="age", required = false, defaultValue = "1") Integer age,
                                     @RequestParam(name="active", required = false, defaultValue = "false") Boolean active){
        return name + "-"+ age + "-"+ active;
    }


    @PostMapping("/requestbody")
    public RequestBodyTest requestBodyLearning(@RequestBody(required = false) RequestBodyTest requestBodyTest){
        return requestBodyTest;
    }




}
