package com.designpatterns.structural.decorater;

public class RetryNotificationDecorator extends DecoratorNotification{
    public RetryNotificationDecorator(NotificationService ns) {
        super(ns);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("Implemented Retry mechanism...");
        notificationService.sendMessage(message);
    }
}
