package com.designpatterns.creational.prototype;

import java.util.HashMap;
import java.util.Map;

class VehicleRegistry {
    private final Map<String, Vehicle> registry = new HashMap<>();

    public void register(String key, Vehicle vehicle) {
        registry.put(key, vehicle);
    }

    public Vehicle getClone(String key) {
        Vehicle vehicle = registry.get(key);

        if (vehicle == null) {
            throw new IllegalArgumentException("No vehicle registered with key: " + key);
        }

        return vehicle.clone();
    }
}
