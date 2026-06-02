package com.designpatterns.behavioural.strategy;

public class Main {
    public static void main(String[] args) {
        CheckoutService razorpayCheckout =
                new CheckoutService(new RazorpayProvider());
        razorpayCheckout.checkout(2000);

        CheckoutService paypalCheckout =
                new CheckoutService(new PaypalProvider());
        paypalCheckout.checkout(3000);
    }
}
