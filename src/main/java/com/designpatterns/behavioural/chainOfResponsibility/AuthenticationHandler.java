package com.designpatterns.behavioural.chainOfResponsibility;

public class AuthenticationHandler extends Handler{
    @Override
    public void handle(Request request) {

        if (!request.isAuthenticated()) {
            System.out.println("Authentication failed");
            return;
        }

        System.out.println("Authentication successful");

        if (nextHandler != null) {
            nextHandler.handle(request);
        }
    }
}
