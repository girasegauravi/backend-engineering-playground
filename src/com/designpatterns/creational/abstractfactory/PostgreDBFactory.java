package com.designpatterns.creational.abstractfactory;

public class PostgreDBFactory implements DBFactory{
    @Override
    public DBConnection getDBConnection() {
        return new PostgreDBConnection();
    }

    @Override
    public UserQuery getUserQuery() {
        return new PostgreUserQuery();
    }
}
