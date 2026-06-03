package com.designpatterns.structural.adapter;

public class StripePaymentAdapter implements PaymentProvider{
    StripePaymentSDK stripePaymentSDK;

    public StripePaymentAdapter(StripePaymentSDK sdk){
        stripePaymentSDK = sdk;
    }

    @Override
    public void pay() {
        stripePaymentSDK.makePayment();
    }
}
