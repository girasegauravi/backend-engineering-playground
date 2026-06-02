package com.designpatterns.behavioural.state;

public class CreatedState implements OrderState {

    @Override
    public void next(Order order) {
        order.setState(new PaidState());
    }

    @Override
    public void printStatus() {
        System.out.println("Order is CREATED");
    }
}
