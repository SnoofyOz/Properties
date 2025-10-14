package com.flrtt.exp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.flrtt.exp"})
public class ExpApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExpApplication.class, args);
    }

}
