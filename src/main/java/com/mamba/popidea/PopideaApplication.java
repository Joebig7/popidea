package com.mamba.popidea;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mamba.popidea.dao")
public class PopideaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PopideaApplication.class, args);
    }
}
