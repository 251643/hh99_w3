package com.sparta.hh99_w3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Hh99W3Application {

    public static void main(String[] args) {
        SpringApplication.run(Hh99W3Application.class, args);
    }

}
