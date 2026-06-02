package com.designpatterns.structural.flyweight;

public class FileIcon implements Icon{
    String type;

    public FileIcon(String type) {
        this.type = type;
        System.out.println("Creating icon object for: " + type);
    }

    @Override
    public void render(int x, int y) {
        System.out.println("Rendering icon " + type + " at: " + x + ", " +y);
    }
}
