package com.cognizant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final EmailService emailService;
    private SMSService smsService;

    @Autowired
    public NotificationService(EmailService emailService) {
        this.emailService = emailService;
        System.out.println("Constructor Injection: EmailService injected!");
    }

    @Autowired
    public void setSMSService(SMSService smsService) {
        this.smsService = smsService;
        System.out.println("Setter Injection: SMSService injected!");
    }

    public void notifyByEmail(String to, String message) {
        String result = emailService.sendEmail(to, message);
        System.out.println(result);
    }

    public void notifyBySMS(String phone, String message) {
        String result = smsService.sendSMS(phone, message);
        System.out.println(result);
    }

    public void notifyAll(String to, String phone, String message) {
        emailService.sendEmail(to, message);
        smsService.sendSMS(phone, message);
        System.out.println("Notified via all channels!");
    }
}
