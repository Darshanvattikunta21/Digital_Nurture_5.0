package com.cognizant;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("com.cognizant")
@EnableJpaRepositories("com.cognizant")
public class AppConfig {
    // Java configuration for Spring component scanning and JPA repository support
}
