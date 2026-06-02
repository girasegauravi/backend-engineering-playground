package com.designpatterns.behavioural.visitor;

public class DrawVisitor implements ShapeVisitor {

    @Override
    public void visit(Circle circle) {
        System.out.println("Drawing Circle");
    }

    @Override
    public void visit(Rectangle rectangle) {
        System.out.println("Drawing Rectangle");
    }
}
