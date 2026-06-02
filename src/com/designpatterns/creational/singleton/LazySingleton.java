package com.designpatterns.creational.singleton;

public class LazySingleton {
    private static LazySingleton INSTANCE;

    private LazySingleton(){}

    public static LazySingleton getInstance() {
        if(INSTANCE == null) {
            try {
                Thread.sleep(2);
            } catch (Exception e) {}

            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }
}
