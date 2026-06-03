package com.designpatterns.behavioural.chainOfResponsibility;

public class BusinessHandler extends Handler{

    @Override
    public void handle(Request request) {
        System.out.println("Executing business logic for " + request.getUser());
    }
}
