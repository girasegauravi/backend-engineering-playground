package com.designpatterns.creational.abstractfactory;

public class MySqlDBFactory implements DBFactory{
    @Override
    public DBConnection getDBConnection() {
        return new MySqlDBConnection();
    }

    @Override
    public UserQuery getUserQuery() {
        return new MySqlUserQuery();
    }
}
