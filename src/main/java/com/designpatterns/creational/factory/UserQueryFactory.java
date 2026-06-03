package com.designpatterns.creational.factory;

public class UserQueryFactory {
    public static UserQuery createUserQuery(String dbType) {
        if (dbType.equalsIgnoreCase("mysql")) {
            return new MySqlUserQuery();
        } else if (dbType.equalsIgnoreCase("postgres")) {
            return new PostgresUserQuery();
        }

        throw new IllegalArgumentException("Unsupported DB type: " + dbType);
    }
}
