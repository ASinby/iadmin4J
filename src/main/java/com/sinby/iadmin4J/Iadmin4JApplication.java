package com.sinby.iadmin4J;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Iadmin4JApplication {

    public static void main(String[] args) {
        SpringApplication.run(Iadmin4JApplication.class, args);
    }

}
