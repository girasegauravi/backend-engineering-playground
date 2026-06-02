package com.designpatterns.structural.bridge;

public abstract class Notification {
    NotificationSender sender;

    public Notification(NotificationSender sender) {
        this.sender = sender;
    }

    abstract void send(String message);

}
