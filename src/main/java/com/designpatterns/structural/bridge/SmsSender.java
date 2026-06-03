package com.designpatterns.structural.bridge;

public class SmsSender implements NotificationSender{
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending Sms:" + message);
    }
}
