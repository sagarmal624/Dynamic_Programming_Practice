package com.example.mongodbpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

@SpringBootApplication

public class MongoDbPocApplication {
    public static void main(String[] args) {
        //ApplicationContext applicationContext = SpringApplication.run(MongoDbPocApplication.class, args);
        List<Integer> nums = Arrays.asList(12, 2434, 23, 1, 654, 222, 56, 100000);
        Collections.sort(nums, (a, b) -> {
            return a.toString().compareTo(b.toString());
        });
        System.out.println(nums);

    }
}
