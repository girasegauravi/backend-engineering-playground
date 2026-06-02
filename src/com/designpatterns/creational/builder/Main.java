package com.designpatterns.creational.builder;

public class Main {
    public static void main(String[] args) {

        User user = User.getBuilder()
                .firstName("John")
                .lastName("Doe")
                .age(30)
                .city("Pune")
                .country("India")
                .isEmployed(true)
                .build();

        System.out.println(user);
    }
}
