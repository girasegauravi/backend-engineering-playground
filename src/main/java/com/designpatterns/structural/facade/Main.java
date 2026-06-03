package com.designpatterns.structural.facade;

public class Main {
    public static void main(String[] args) {
        NotificationFacade notificationFacade =
                new NotificationFacade(
                        new TemplateService(),
                        new EmailService(),
                        new AuditService(),
                        new MetricsService()
                );

        notificationFacade
                .sendPaymentSuccessNotification("test@gmail.com");
    }
}
