// main class to start my loan microservice
package com.cognizant.loan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoanApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoanApplication.class, args);
        System.out.println("Loan Microservice is running on port 8082");
        System.out.println("Test URL: http://localhost:8082/api/loans");
        System.out.println("H2 Console: http://localhost:8082/h2-console");
    }
}
