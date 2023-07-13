package com.StreamingApp.WildFlixMSH.services;

public interface EmailService {
    void sendEmail(String toUser, String subject, String body);
}
