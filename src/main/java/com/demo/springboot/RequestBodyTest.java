package com.demo.springboot;

import java.io.Serializable;

public class RequestBodyTest implements Serializable {

    private String name;
    private String dob;
    private Integer age;
    private Boolean ismarried;

    public void setIsmarried(Boolean ismarried) {
        this.ismarried = ismarried;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setAge(Integer age) {
        this.age = age;
    }




    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public Integer getAge() {
        return age;
    }

    public Boolean getIsmarried() {
        return ismarried;
    }
}
