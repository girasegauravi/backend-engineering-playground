package com.designpatterns.creational.abstractfactory;

public class MySqlUserQuery implements UserQuery {
    @Override
    public void findUserById(String userId) {
        System.out.println("Implementing Mysql User query.");
    }
}
