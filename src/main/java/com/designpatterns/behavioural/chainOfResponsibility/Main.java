package com.designpatterns.behavioural.chainOfResponsibility;

public class Main {
    public static void main(String[] args) {

        Handler logging = new LoggingHandler();
        Handler auth = new AuthenticationHandler();
        Handler business = new BusinessHandler();

        logging.setNext(auth).setNext(business);

        Request request = new Request("gaurav", true);

        logging.handle(request);
    }
}
