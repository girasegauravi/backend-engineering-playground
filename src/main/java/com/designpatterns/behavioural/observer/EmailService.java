package com.designpatterns.behavioural.observer;

public class EmailService implements OrderListener{
    @Override
    public void onOrderPlaced(String orderId) {
        System.out.println(
                "Email sent for order: " + orderId
        );
    }
}
