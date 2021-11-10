package com.example.mongodbpoc.practice;

import java.util.HashMap;
import java.util.Map;

public class DEMO {


    public static void main(String[] args) {

        Map<Student, String> map = new HashMap<>();
        map.put(new Student("sagar"), "sagar");
        map.put(new Student("raul"), "sagar");
        map.put(new Student("test"), "sagar");
        map.put(new Student("te"), "sagar");
        System.out.println(map.size());
    }
}
