package com.designpatterns.creational.abstractfactory;

public interface DBFactory {
    DBConnection getDBConnection();
    UserQuery getUserQuery();
}
