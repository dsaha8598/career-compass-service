package com.demo.springboot;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataBaseTest {

    public List<RequestBodyTest> getAllRequestBody() {
        List<RequestBodyTest> requestBodyTestList;
        requestBodyTestList = Arrays.asList(
                new RequestBodyTest("dipak", "0606", 27, false),
                new RequestBodyTest("hemant", "0606", 23, true),
                new RequestBodyTest("Abhay", "0606", 21, false),
                new RequestBodyTest("Jagdish", "0606", 22, true),
                new RequestBodyTest("Shradha", "0606", 20, true)
        );
        return requestBodyTestList;
    }

}
