package com.designpatterns.behavioural.memento;

public class HistoryManager {
    private EditorMemento memento;

    public void save(EditorMemento memento) {
        this.memento = memento;
    }

    public EditorMemento getMemento() {
        return memento;
    }
}
