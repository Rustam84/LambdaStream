package com.endava.models;

import java.util.List;

public class Student extends User {
    Major major;

    public Student(String name, Gender gender, int age, Major major) {
        super(name, gender, age);
        this.major = major;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }
}
