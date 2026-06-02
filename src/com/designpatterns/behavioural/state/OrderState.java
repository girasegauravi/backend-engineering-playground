package com.designpatterns.behavioural.state;

public interface OrderState {
    void next(Order order);
    void printStatus();
}
