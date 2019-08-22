package com.example.demo.app;

import com.example.demo.entity.Auto;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
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
