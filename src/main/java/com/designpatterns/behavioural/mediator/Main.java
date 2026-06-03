package com.designpatterns.behavioural.mediator;

public class Main {

    public static void main(String[] args) {

        ChatMediator mediator = new ChatRoomMediator();

        User gaurav = new ChatUser(mediator, "Gaurav");
        User aman = new ChatUser(mediator, "Aman");
        User rahul = new ChatUser(mediator, "Rahul");

        mediator.addUser(gaurav);
        mediator.addUser(aman);
        mediator.addUser(rahul);

        gaurav.send("Hello everyone!");
    }
}
