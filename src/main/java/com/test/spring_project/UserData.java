package com.test.spring_project;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name="uesr_details")
public class UserData {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;
    private Long phone;
    private String gender;
    private Integer age;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Long getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
