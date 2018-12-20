package com.cmfz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.cmfz.mapper")
@SpringBootApplication
public class SsmcmfzApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsmcmfzApplication.class, args);
    }

}

