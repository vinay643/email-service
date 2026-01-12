package com.homemate.email_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/send-email")
    public String sendEmail(@RequestBody String message) {
        String lastWord =
                message.substring(message.lastIndexOf(" ") + 1);

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("vinayrajpoot64@gmail.com");   // demo receiver
        mail.setSubject("Service Booking Confirmation");
        mail.setText(message);

        mailSender.send(mail);
        return "EMAIL_SENT";
    }
}

