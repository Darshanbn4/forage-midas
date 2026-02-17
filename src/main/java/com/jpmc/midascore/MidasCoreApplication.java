package com.jpmc.midascore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.jpmc.midascore")
public class MidasCoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(MidasCoreApplication.class, args);
    }
}

