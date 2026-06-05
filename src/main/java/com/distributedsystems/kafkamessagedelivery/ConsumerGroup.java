package com.distributedsystems.kafkamessagedelivery;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConsumerGroup {
    private final String groupId;

    // topic-partition -> committed offset
    private final Map<String, Long> offsets = new ConcurrentHashMap<>();

    ConsumerGroup(String groupId) {
        this.groupId = groupId;
    }

    public long committedOffset(String topic, int partitionId) {
        return offsets.getOrDefault(topic + "-" + partitionId, 0L);
    }

    public void commit(String topic, int partitionId, long nextOffset) {
        offsets.put(topic + "-" + partitionId, nextOffset);
    }
}
