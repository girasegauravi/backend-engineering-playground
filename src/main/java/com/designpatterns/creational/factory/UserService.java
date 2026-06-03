package com.designpatterns.creational.factory;

public class UserService {
    UserQuery userQuery;

    public UserService(String dbType) {
        this.userQuery = UserQueryFactory.createUserQuery(dbType);
    }

    public void getUser(String userId) {
        userQuery.findUserById(userId);
    }
}
