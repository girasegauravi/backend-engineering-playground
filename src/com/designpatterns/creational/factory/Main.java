package com.designpatterns.creational.factory;

public class Main {
    public static void main(String[] args) {
        UserService mysqlUserService = new UserService("mysql");
        mysqlUserService.getUser("101");

        UserService postgresUserService = new UserService("postgres");
        postgresUserService.getUser("202");
    }
}
