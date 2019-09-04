package com.example.demo.app;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories("com.example.demo.repositories")
public class TaskTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskTestApplication.class, args);
        String userName = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3307/automobiles?useSSL=false";
        String driver = System.getProperty("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            DSLContext dslContext = DSL.using(connection, SQLDialect.MYSQL);
            Result<?> result = dslContext.select().from().fetch();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
