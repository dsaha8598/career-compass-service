package com.test.spring_project;

import java.io.Serializable;

public class UserResponse implements Serializable {

    private String name;
    private String dob;
    private int age;
    private boolean isMarrage;

    public UserResponse(String name,String dob, int age, boolean isMarrage) {
        this.name = name;
        this.dob=dob;
        this.age = age;
        this.isMarrage = isMarrage;
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

    public void setMarrage(boolean marrage) {
        isMarrage = marrage;
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

    public boolean isMarrage() {
        return isMarrage;
    }


}
