package com.designpatterns.creational.abstractfactory;

public class Main {
    public static void main(String[] args) {
        DBFactory mysqlFactory = new MySqlDBFactory();
        UserService mysqlUserService = new UserService(mysqlFactory);
        mysqlUserService.getUser("101");

        System.out.println("-----");

        DBFactory postgresFactory = new PostgreDBFactory();
        UserService postgresUserService = new UserService(postgresFactory);
        postgresUserService.getUser("202");
    }
}
