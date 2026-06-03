package com.designpatterns.structural.bridge;

public class ReminderNotification extends Notification {
    public ReminderNotification(NotificationSender sender) {
        super(sender);
    }

    @Override
    void send(String message) {
        sender.sendNotification("[REMINDER]: " + message);
    }
}
