package com.designpatterns.creational.prototype;

public class Main {
    public static void main(String[] args) {
        VehicleRegistry registry = new VehicleRegistry();

        Vehicle carPrototype = new Vehicle("Car", "Petrol Engine", "White");
        Vehicle bikePrototype = new Vehicle("Bike", "150cc Engine", "Black");

        registry.register("car", carPrototype);
        registry.register("bike", bikePrototype);

        Vehicle car1 = registry.getClone("car");
        car1.setColor("Red");

        Vehicle car2 = registry.getClone("car");
        car2.setColor("Blue");

        Vehicle bike1 = registry.getClone("bike");
        bike1.setColor("Green");

        carPrototype.display();
        car1.display();
        car2.display();
        bikePrototype.display();
        bike1.display();
    }
}
