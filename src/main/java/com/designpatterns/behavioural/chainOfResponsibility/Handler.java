package com.designpatterns.behavioural.chainOfResponsibility;

public abstract class Handler {
    protected Handler nextHandler;

    public Handler setNext(Handler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public abstract void handle(Request request);
}
