package com.cognizant;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    private HelloService helloService;

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }

    public static void main(String[] args) {
        System.out.println("=== Spring Application Started ===");

        try (AnnotationConfigApplicationContext javaContext = new AnnotationConfigApplicationContext(AppConfig.class)) {
            HelloService javaHelloService = javaContext.getBean(HelloService.class);
            String javaGreeting = javaHelloService.greet("Cognizant Developer");
            System.out.println(javaGreeting);
            System.out.println(javaHelloService.getInfo());
        }

        try (ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            HelloService xmlHelloService = xmlContext.getBean(HelloService.class);
            System.out.println(xmlHelloService.greet("Spring XML Config"));
        }

        System.out.println("=== Spring Application Completed ===");
    }
}
