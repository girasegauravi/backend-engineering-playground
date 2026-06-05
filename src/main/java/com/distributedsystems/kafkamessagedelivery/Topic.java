package com.distributedsystems.kafkamessagedelivery;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    private final List<Partition> partitions;

    Topic(int partitionCount) {
        this.partitions = new ArrayList<>();
        for (int i = 0; i < partitionCount; i++) {
            partitions.add(new Partition());
        }
    }

    public int choosePartition(String key) {
        return Math.abs(key.hashCode()) % partitions.size();
    }

    public Partition getPartition(int partitionId) {
        return partitions.get(partitionId);
    }

    public int partitionCount() {
        return partitions.size();
    }
}
