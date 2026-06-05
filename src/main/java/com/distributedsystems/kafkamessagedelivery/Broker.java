package com.distributedsystems.kafkamessagedelivery;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Broker {
    private final Map<String, Topic> topics = new ConcurrentHashMap<>();

    public void createTopic(String topicName, int partitions) {
        topics.put(topicName, new Topic(partitions));
    }

    public long send(String topicName, String key, String value) {
        Topic topic = topics.get(topicName);
        int partitionId = topic.choosePartition(key);

        long offset = topic.getPartition(partitionId).append(key, value);

        System.out.println("Produced to partition " + partitionId + " at offset " + offset);
        return offset;
    }

    public List<Message> poll(String topicName, int partitionId, long offset, int maxMessages) {
        return topics.get(topicName)
                .getPartition(partitionId)
                .readFrom(offset, maxMessages);
    }

    public int partitionCount(String topicName) {
        return topics.get(topicName).partitionCount();
    }
}
