package com.distributedsystems.kafkamessagedelivery;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Partition {
    private final List<Message> log = new ArrayList<>();
    private final AtomicLong nextOffset = new AtomicLong(0);

    public synchronized long append(String key, String value) {
        long offset = nextOffset.getAndIncrement();
        log.add(new Message(offset, key, value));
        return offset;
    }

    public synchronized List<Message> readFrom(long offset, int maxMessages) {
        List<Message> result = new ArrayList<>();

        for (Message message : log) {
            if (message.offset >= offset) {
                result.add(message);
                if (result.size() == maxMessages) break;
            }
        }

        return result;
    }
}
