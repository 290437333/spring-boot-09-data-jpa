package com.example.springboot.entity;

public class User {
    private String username;

    private Integer gender;

    public User() {
    }
    public User(String username, Integer gender) {
        this.username = username;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
