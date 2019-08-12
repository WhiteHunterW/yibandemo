package com.you.yiban;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.you.yiban.dao")
public class YibanApplication {

    public static void main(String[] args) {
        SpringApplication.run(YibanApplication.class, args);
    }

}
