package com.example.demo;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
@Transactional("transactionManager")
public class TaskTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskTestApplication.class, args);
	}
}
