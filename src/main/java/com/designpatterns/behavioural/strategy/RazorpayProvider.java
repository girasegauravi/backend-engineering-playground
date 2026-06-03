package com.designpatterns.behavioural.strategy;

public class RazorpayProvider implements PaymentStrategy{
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Razorpay");
    }
}
