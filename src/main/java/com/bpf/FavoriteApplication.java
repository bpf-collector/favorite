package com.bpf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class FavoriteApplication {

    public static void main(String[] args) {
        SpringApplication.run(FavoriteApplication.class, args);
    }
}
