package com.cognizant;

import org.springframework.stereotype.Service;

@Service
public class SMSService {

    public String sendSMS(String phoneNumber, String message) {
        String output = "SMS SENT TO: " + phoneNumber + " | MESSAGE: " + message;
        System.out.println(output);
        return "SMS sent successfully to " + phoneNumber;
    }
}
