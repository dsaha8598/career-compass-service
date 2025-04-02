package com.demo.springboot;

public class UserRequestBody {

    private String name;
    private String email;
    private Long ph;
    private String gender;
    private Integer age;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Long getPh() {
        return ph;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPh(Long ph) {
        this.ph = ph;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }
}
