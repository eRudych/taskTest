package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;


@SpringBootApplication
@Transactional("transactionManager")

public class TaskTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskTestApplication.class, args);
    }
}
