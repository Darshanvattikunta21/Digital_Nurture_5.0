package com.cognizant;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public String sendEmail(String to, String message) {
        String output = "EMAIL SENT TO: " + to + " | MESSAGE: " + message;
        System.out.println(output);
        return "Email sent successfully to " + to;
    }
}
