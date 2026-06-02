package com.designpatterns.behavioural.state;

class PaidState implements OrderState {

    @Override
    public void next(Order order) {
        order.setState(new ShippedState());
    }

    @Override
    public void printStatus() {
        System.out.println("Order is PAID");
    }
}