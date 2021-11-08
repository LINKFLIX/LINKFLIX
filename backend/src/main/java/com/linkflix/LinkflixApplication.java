package com.linkflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LinkflixApplication {

    public static void main(String[] args) {
        SpringApplication.run(LinkflixApplication.class, args);
    }

}
