package com.designpatterns.structural.facade;

class EmailService {
    public void sendEmail(String email, String content) {
        System.out.println("Email sent to " + email + " : " + content);
    }
}