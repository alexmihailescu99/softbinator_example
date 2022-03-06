package com.example.softbinator_example;

import com.example.softbinator_example.example.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoftbinatorExampleApplication {

    // Annotation-ul Bean notifica Spring sa faca clasa noastra "injectabila"
    // Vezi UserService pentru a vedea injectarea efectiva a Car-ului
    @Bean
    Car car() {
        return new Car();
    }

    public static void main(String[] args) {
        SpringApplication.run(SoftbinatorExampleApplication.class, args);
    }

}
