package com.test.spring_project;

public class UserResponse {

    private String name;
    private int age;
    private boolean isMarrage;

    public UserResponse(String name, int age, boolean isMarrage) {
        this.name = name;
        this.age = age;
        this.isMarrage = isMarrage;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getAge() {
        return age;
    }

    public boolean isMarrage() {
        return isMarrage;
    }


}
