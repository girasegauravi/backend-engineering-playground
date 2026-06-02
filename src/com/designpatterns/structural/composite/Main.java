package com.designpatterns.structural.composite;

public class Main {
    public static void main(String[] args) {
        File resume = new File("resume.pdf");
        File photo = new File("photo.png");

        Folder documents = new Folder("Documents");
        documents.add(resume);

        Folder root = new Folder("Root");
        root.add(documents);
        root.add(photo);

        root.show("");
    }
}
