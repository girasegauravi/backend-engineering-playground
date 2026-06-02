package com.designpatterns.creational.prototype;

class Vehicle implements Prototype<Vehicle> {
    private String type;
    private String engine;
    private String color;

    public Vehicle(String type, String engine, String color) {
        this.type = type;
        this.engine = engine;
        this.color = color;
    }

    // Copy constructor
    public Vehicle(Vehicle vehicle) {
        this.type = vehicle.type;
        this.engine = vehicle.engine;
        this.color = vehicle.color;
    }

    @Override
    public Vehicle clone() {
        return new Vehicle(this);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void display() {
        System.out.println("Vehicle{" +
                "type='" + type + '\'' +
                ", engine='" + engine + '\'' +
                ", color='" + color + '\'' +
                '}');
    }
}