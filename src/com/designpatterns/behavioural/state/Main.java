package com.designpatterns.behavioural.state;

public class Main {
    public static void main(String[] args) {

        Order order = new Order();

        order.printStatus();

        order.nextState();
        order.printStatus();

        order.nextState();
        order.printStatus();

        order.nextState();
    }
}
