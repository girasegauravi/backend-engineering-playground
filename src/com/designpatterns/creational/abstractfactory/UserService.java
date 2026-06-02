package com.designpatterns.creational.abstractfactory;

public class UserService {
    DBConnection conn;
    UserQuery query;

    public UserService(DBFactory dbFactory){
        this.conn = dbFactory.getDBConnection();;
        this.query = dbFactory.getUserQuery();
    }

    public void getUser(String userId) {
        conn.connect();
        query.findUserById(userId);
    }
}
