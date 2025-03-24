package com.demo.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/helloworld")
    public static String test1(){
        return "Hello World";
    }

    @GetMapping("/helloworld2")
    public static String test2(){
        return "Hello World 2";
    }

    @GetMapping("/helloworld3")
    public static String test3(){
        return "Hello World 3";
    }

    @GetMapping("/helloworld-test")
    public TestResponse  test4(){

        return new TestResponse(27, "dipak", false);
    }


}
