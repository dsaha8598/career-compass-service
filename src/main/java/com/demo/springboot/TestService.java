package com.demo.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component
@Service
public class TestService {

    @Autowired
    private DataBaseTest dataBaseTest;

    public String m1(Integer number, String name) {
       return " method m1 printed" + number+"   name is   "+ name;
    }

    public String m2(String name, Integer age, Boolean active){
        return "printingn form service m2 : name="+name + "  age ="+ age + " active="+ active;
    }

    public List<RequestBodyTest> getAll(){
        return dataBaseTest.getAllRequestBody();
    }
}

