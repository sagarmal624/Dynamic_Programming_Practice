package com.example.mongodbpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.RequestScope;

@SpringBootApplication

public class MongoDbPocApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(MongoDbPocApplication.class, args);


    }
}
