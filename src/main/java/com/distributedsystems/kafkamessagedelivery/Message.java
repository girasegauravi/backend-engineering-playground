package com.distributedsystems.kafkamessagedelivery;

public class Message {
    final long offset;
    final String key;
    final String value;

    Message(long offset, String key, String value) {
        this.offset = offset;
        this.key = key;
        this.value = value;
    }

    public String toString() {
        return "offset=" + offset + ", key=" + key + ", value=" + value;
    }
}
