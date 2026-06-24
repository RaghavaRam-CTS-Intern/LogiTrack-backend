package com.cognizant.logitrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class LogiTrackApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogiTrackApplication.class, args);
    }
}
