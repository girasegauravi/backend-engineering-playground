package com.designpatterns.behavioural.visitor;

public interface ShapeVisitor {
    void visit(Circle circle);

    void visit(Rectangle rectangle);
}
