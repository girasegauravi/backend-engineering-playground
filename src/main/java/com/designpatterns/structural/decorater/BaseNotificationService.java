package com.designpatterns.structural.decorater;

public class BaseNotificationService implements NotificationService{

    @Override
    public void sendMessage(String message) {
        System.out.println("Sending notification: " + message);
    }
}
