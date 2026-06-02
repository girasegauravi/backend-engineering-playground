package com.designpatterns.structural.adapter;

public class Main {
    public static void main(String[] args) {
        StripePaymentSDK sdk = new StripePaymentSDK();
        PaymentProvider pp = new StripePaymentAdapter(sdk);
        pp.pay();
    }
}
