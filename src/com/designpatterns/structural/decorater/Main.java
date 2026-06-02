package com.designpatterns.structural.decorater;

public class Main {
    public static void main(String[] args) {
        NotificationService ns = new LoggerNotificationDecorator(
                new RetryNotificationDecorator(
                        new BaseNotificationService()
                )
        );
        ns.sendMessage("Hello World");
    }
}
