package com.mysql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@MapperScan("com.mysql.mapper")
@EntityScan("com.mysql.model")
@SpringBootApplication
public class MysqlStart {

    public static void main(String[] args) {
        SpringApplication.run(MysqlStart.class, args);
    }
}
