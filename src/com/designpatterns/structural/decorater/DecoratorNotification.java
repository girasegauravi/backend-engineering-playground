package com.designpatterns.structural.decorater;

abstract class DecoratorNotification implements NotificationService{

    protected final NotificationService notificationService;

    public DecoratorNotification(NotificationService ns) {
        this.notificationService = ns;
    }
}
