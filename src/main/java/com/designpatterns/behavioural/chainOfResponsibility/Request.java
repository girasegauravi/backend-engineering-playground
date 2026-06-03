package com.designpatterns.behavioural.chainOfResponsibility;

public class Request {
    private final String user;
    private final boolean authenticated;

    public Request(String user, boolean authenticated) {
        this.user = user;
        this.authenticated = authenticated;
    }

    public String getUser() {
        return user;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }
}
