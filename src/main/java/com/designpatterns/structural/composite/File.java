package com.designpatterns.structural.composite;

public class File implements FileSystemItem {
    private final String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void show(String indent) {
        System.out.println(indent + "File: " + name);
    }
}
