package com.designpatterns.behavioural.observer;

public class AuditService implements OrderListener{
    @Override
    public void onOrderPlaced(String orderId) {
        System.out.println(
                "Audit log created for order: " + orderId
        );
    }
}
