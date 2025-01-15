package org.example.config;

import org.example.InMemoryContactOperations;
import org.example.ContactOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContactOperationsConfig {

    @Bean
    public ContactOperations contactOperations(){
        return new InMemoryContactOperations();
    }
}

