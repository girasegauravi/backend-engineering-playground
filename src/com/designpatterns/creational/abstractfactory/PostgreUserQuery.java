package com.designpatterns.creational.abstractfactory;

public class PostgreUserQuery implements UserQuery {
    @Override
    public void findUserById(String userId) {
        System.out.println("Implementing Postgre User query.");
    }
}
