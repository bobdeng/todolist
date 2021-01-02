package cn.bobdeng.todolist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class TodolistApplication {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(TodolistApplication.class, args);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CommandController commandController = applicationContext.getBean(CommandController.class);
        String line;
        while ((line = reader.readLine()) != null) {
            commandController.run(line.split("\\s+"));
        }
    }

}
