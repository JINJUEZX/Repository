package com.example.lianxi0325;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.lianxi0325.mapper")
public class Lianxi0325Application {

    public static void main(String[] args) {
        SpringApplication.run(Lianxi0325Application.class, args);
    }

}
