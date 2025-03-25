package com.example.springboot_project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController2 {
    @GetMapping("/Pathparam/{number}")
    public String toCatchPathParam(){
        return "pathparam";
    }
}
