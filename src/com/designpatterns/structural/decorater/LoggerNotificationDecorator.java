package com.designpatterns.structural.decorater;

public class LoggerNotificationDecorator extends DecoratorNotification {

    public LoggerNotificationDecorator(NotificationService ns) {
        super(ns);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("Logging notification...");
        notificationService.sendMessage(message);
    }
}
