package com.example.demo.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class ClientConfig {

    @Bean
    CommandLineRunner commandLineRunner(ClientRepository repository) {
        return args -> {
            Client john = new Client(1L, "John", "john@gmail.com",
                    LocalDate.of(1930, 8, 25));
            Client jen = new Client(2L, "Jen", "jen@gmail.com",
                    LocalDate.of(1975, 3, 3));
            repository.saveAll(List.of(john, jen));
        };
    };
}
