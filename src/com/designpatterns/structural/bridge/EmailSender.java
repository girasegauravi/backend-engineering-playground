package com.designpatterns.structural.bridge;

public class EmailSender implements NotificationSender{
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending Email:" + message);
    }
}
