package com.designpatterns.behavioural.command;

import java.util.LinkedList;
import java.util.Queue;

public class TaskQueue {
    private final Queue<Command> queue = new LinkedList<>();

    public void add(Command command) {
        queue.add(command);
    }

    public void runAll() {
        while (!queue.isEmpty()) {
            queue.poll().execute();
        }
    }
}
