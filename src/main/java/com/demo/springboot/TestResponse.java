package com.demo.springboot;

public class TestResponse {

    private String name;
    private int age;
    private boolean isMarried;

    public TestResponse(int age, String name, boolean isMarried) {
        this.age = age;
        this.name = name;
        this.isMarried = isMarried;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isMarried() {
        return isMarried;
    }


}
