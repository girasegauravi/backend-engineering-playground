package com.designpatterns.behavioural.visitor;

public class Main {
    public static void main(String[] args) {

        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        ShapeVisitor drawVisitor =
                new DrawVisitor();

        ShapeVisitor areaVisitor =
                new AreaVisitor();

        circle.accept(drawVisitor);
        rectangle.accept(drawVisitor);

        circle.accept(areaVisitor);
        rectangle.accept(areaVisitor);
    }
}
