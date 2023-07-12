package com.StreamingApp.WildFlixMSH.servicesImplem;

import com.StreamingApp.WildFlixMSH.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailImplem implements EmailService {
    @Autowired
    JavaMailSender emailSender;
    @Override
    public void sendEmail(String toUser, String subject, String body) {
        SimpleMailMessage  message = new SimpleMailMessage();
        message.setTo(toUser);
        message.setSubject(subject);
        message.setText(body);
        emailSender.send(message);
    }
}
