package com.designpatterns.structural.bridge;

public class AlertNotification extends Notification {
    public AlertNotification(NotificationSender sender) {
        super(sender);
    }

    @Override
    void send(String message) {
        sender.sendNotification("[ALERT]: " + message);
    }
}
