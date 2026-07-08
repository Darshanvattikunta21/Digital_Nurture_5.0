package com.cognizant;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        System.out.println("=== Dependency Injection Demo ===");

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            NotificationService notificationService = context.getBean(NotificationService.class);
            notificationService.notifyByEmail("rahul@test.com", "Welcome to Cognizant!");
            notificationService.notifyBySMS("9876543210", "Your OTP is 1234");
            notificationService.notifyAll("priya@test.com", "8765432109", "Meeting at 3PM");
            System.out.println("=== Constructor Injection and Setter Injection Demonstrated ===");
        }
    }
}
