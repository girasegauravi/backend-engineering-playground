package com.designpatterns.behavioural.observer;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private final List<OrderListener> listeners = new ArrayList<>();

    public void registerListener(OrderListener listener) {
        listeners.add(listener);
    }

    public void placeOrder(String orderId) {

        System.out.println("Order placed: " + orderId);
        notifyListeners(orderId);
    }

    private void notifyListeners(String orderId) {
        for (OrderListener listener : listeners) {
            listener.onOrderPlaced(orderId);
        }
    }
}
