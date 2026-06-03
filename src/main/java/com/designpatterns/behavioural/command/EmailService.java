package com.designpatterns.behavioural.command;

public class EmailService {
    public void sendEmail(String email, String message) {
        System.out.println("Email sent to " + email + ": " + message);
    }
}
