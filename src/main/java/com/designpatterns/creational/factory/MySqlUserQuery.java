package com.designpatterns.creational.factory;

public class MySqlUserQuery implements UserQuery{
    @Override
    public void findUserById(String userId) {
        System.out.println("Executing MySQL query: SELECT * FROM users WHERE id = " + userId);
    }
}
