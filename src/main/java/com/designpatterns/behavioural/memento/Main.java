package com.designpatterns.behavioural.memento;

public class Main {

    public static void main(String[] args) {

        TextEditor editor =
                new TextEditor();

        HistoryManager history =
                new HistoryManager();

        editor.write("Version 1");
        history.save(editor.save());

        editor.write("Version 2");

        System.out.println("Current:");
        editor.show();

        editor.restore(history.getMemento());

        System.out.println("After Restore:");
        editor.show();
    }
}
