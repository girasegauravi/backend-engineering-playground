package com.designpatterns.creational.abstractfactory;

public class MySqlDBConnection implements DBConnection{
    @Override
    public void connect() {
        System.out.println("This is MySQLConnection.");
    }
}
