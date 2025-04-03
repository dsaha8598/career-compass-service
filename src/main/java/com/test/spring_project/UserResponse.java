package com.test.spring_project;

import java.io.Serializable;

public class UserResponse implements Serializable {

    private String name;
    private String dob;
    private int age;
    private boolean isMarried;

    public UserResponse(String name,String dob, int age, boolean isMarried) {
        this.name = name;
        this.dob=dob;
        this.age = age;
        this.isMarried = isMarried;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setisMarried(boolean isMarried) {
        this.isMarried = isMarried;
    }

    public String getName() {
        return name;
    }
    public String getDob() {
        return dob;
    }

    public int getAge() {
        return age;
    }

    public boolean getisMarrage() {
        return isMarried;
    }


}
