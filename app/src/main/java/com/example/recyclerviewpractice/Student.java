package com.example.recyclerviewpractice;

public class Student {
    private String name;
    private String mobileNumber;
    private String email;

    public Student(String name, String mobileNumber, String email) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }
}