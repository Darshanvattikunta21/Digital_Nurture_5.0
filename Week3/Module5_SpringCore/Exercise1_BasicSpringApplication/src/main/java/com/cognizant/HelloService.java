package com.cognizant;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String greet(String name) {
        System.out.println("Executing HelloService.greet()");
        return "Hello, " + name + "! Welcome to Spring Framework.";
    }

    public String getInfo() {
        System.out.println("Executing HelloService.getInfo()");
        return "HelloService is running successfully!";
    }
}
