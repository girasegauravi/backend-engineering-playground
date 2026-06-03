package com.designpatterns.structural.bridge;

public class Main {
    public static void main(String[] args) {
        NotificationSender ns = new EmailSender();

        Notification notification = new AlertNotification(ns);
        notification.send("This is an alert");

        notification = new ReminderNotification(ns);
        notification.send("This is an reminder");

        ns = new SmsSender();
        notification = new AlertNotification(ns);
        notification.send("This is an alert");

        notification = new ReminderNotification(ns);
        notification.send("This is an reminder");
    }
}
