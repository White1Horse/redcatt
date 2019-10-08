package com.redcatt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan("com.redcatt.dao")
@SpringBootApplication
public class RedcattApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedcattApplication.class, args);
    }

}
