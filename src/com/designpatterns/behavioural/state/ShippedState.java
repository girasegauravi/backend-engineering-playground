package com.designpatterns.behavioural.state;

class ShippedState implements OrderState {

    @Override
    public void next(Order order) {
        System.out.println("Order already shipped");
    }

    @Override
    public void printStatus() {
        System.out.println("Order is SHIPPED");
    }
}