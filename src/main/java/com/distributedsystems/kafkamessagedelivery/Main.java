package com.distributedsystems.kafkamessagedelivery;

public class Main {
    public static void main(String[] args) {
        Broker broker = new Broker();
        broker.createTopic("orders", 3);

        broker.send("orders", "customer-1", "OrderCreated");
        broker.send("orders", "customer-1", "OrderPaid");
        broker.send("orders", "customer-2", "OrderCreated");
        broker.send("orders", "customer-1", "OrderShipped");

        ConsumerGroup group = new ConsumerGroup("order-processor");

        Consumer c0 = new Consumer(broker, group, "orders", 0);
        Consumer c1 = new Consumer(broker, group, "orders", 1);
        Consumer c2 = new Consumer(broker, group, "orders", 2);

        c0.pollAndProcess();
        c1.pollAndProcess();
        c2.pollAndProcess();
    }
}
