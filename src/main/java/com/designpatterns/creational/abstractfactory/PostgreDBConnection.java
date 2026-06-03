package com.designpatterns.creational.abstractfactory;

public class PostgreDBConnection implements DBConnection{
    @Override
    public void connect() {
        System.out.println("This is PostgreSQL Connection.");
    }
}
