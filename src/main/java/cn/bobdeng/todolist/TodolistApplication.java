package cn.bobdeng.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@SpringBootApplication
public class TodolistApplication {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(TodolistApplication.class, args);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CommandController commandController = applicationContext.getBean(CommandController.class);
        System.out.print("todo ");
        String line;
        while ((line = reader.readLine()) != null) {
            commandController.run(line.split("\\s+"));
        }
    }

}
