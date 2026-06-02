package com.designpatterns.behavioural.chainOfResponsibility;

public class LoggingHandler extends Handler{
    @Override
    public void handle(Request request) {
        System.out.println("Logging request for user: " + request.getUser());

        if (nextHandler != null) {
            nextHandler.handle(request);
        }
    }
}
