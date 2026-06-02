package com.designpatterns.structural.flyweight;

public class Main {
    public static void main(String[] args) {
        Icon pdf1 = IconFactory.getIcon("PDF");
        pdf1.render(10, 20);

        Icon pdf2 = IconFactory.getIcon("PDF");
        pdf2.render(30, 40);

        Icon image = IconFactory.getIcon("IMAGE");
        image.render(50, 60);
    }
}
