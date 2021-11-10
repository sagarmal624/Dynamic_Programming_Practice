package com.example.mongodbpoc.practice;

import java.util.Objects;

public class Student {
    private String name;

    public Student(String name) {
       this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
