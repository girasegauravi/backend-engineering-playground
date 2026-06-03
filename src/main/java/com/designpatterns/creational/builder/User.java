package com.designpatterns.creational.builder;

class User {

    // required + optional fields
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String city;
    private final String country;
    private final boolean isEmployed;
    private final boolean isMarried;

    private User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.city = builder.city;
        this.country = builder.country;
        this.isEmployed = builder.isEmployed;
        this.isMarried = builder.isMarried;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    // static builder class
    static class Builder {

        private String firstName;
        private String lastName;
        private int age;
        private String city;
        private String country;
        private boolean isEmployed;
        private boolean isMarried;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder isEmployed(boolean isEmployed) {
            this.isEmployed = isEmployed;
            return this;
        }

        public Builder isMarried(boolean isMarried) {
            this.isMarried = isMarried;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + age;
    }
}