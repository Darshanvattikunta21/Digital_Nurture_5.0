// this is the main class that starts my account microservice
package com.cognizant.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
        System.out.println("Account Microservice is running on port 8081");
        System.out.println("Test URL: http://localhost:8081/api/accounts");
        System.out.println("H2 Console: http://localhost:8081/h2-console");
    }
}
