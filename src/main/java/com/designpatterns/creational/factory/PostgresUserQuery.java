package com.designpatterns.creational.factory;

public class PostgresUserQuery implements UserQuery{
    @Override
    public void findUserById(String userId) {
        System.out.println("Executing PostgreSQL query: SELECT * FROM users WHERE id = " + userId);
    }
}
