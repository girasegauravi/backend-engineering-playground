package com.designpatterns.behavioural.visitor;

public class AreaVisitor implements ShapeVisitor {

    @Override
    public void visit(Circle circle) {
        System.out.println("Calculating Circle Area");
    }

    @Override
    public void visit(Rectangle rectangle) {
        System.out.println("Calculating Rectangle Area");
    }
}
