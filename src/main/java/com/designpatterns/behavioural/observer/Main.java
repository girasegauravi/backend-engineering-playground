package com.designpatterns.behavioural.observer;

public class Main {

    public static void main(String[] args) {

        OrderService orderService = new OrderService();
        orderService.registerListener(new EmailService());
        orderService.registerListener(new AuditService());
        orderService.placeOrder("ORDER-101");
    }
}
