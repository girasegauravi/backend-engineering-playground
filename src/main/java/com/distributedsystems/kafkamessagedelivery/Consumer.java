package com.distributedsystems.kafkamessagedelivery;

import java.util.List;

public class Consumer {
    private final Broker broker;
    private final ConsumerGroup group;
    private final String topic;
    private final int partitionId;

    Consumer(Broker broker, ConsumerGroup group, String topic, int partitionId) {
        this.broker = broker;
        this.group = group;
        this.topic = topic;
        this.partitionId = partitionId;
    }

    public void pollAndProcess() {
        long offset = group.committedOffset(topic, partitionId);

        List<Message> messages = broker.poll(topic, partitionId, offset, 10);

        for (Message message : messages) {
            System.out.println("Consumer processing partition " + partitionId + ": " + message);

            // process first, then commit next offset
            group.commit(topic, partitionId, message.offset + 1);
        }
    }
}
