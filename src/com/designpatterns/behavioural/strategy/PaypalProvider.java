package com.designpatterns.behavioural.strategy;

public class PaypalProvider implements PaymentStrategy{
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Paypal");
    }
}
