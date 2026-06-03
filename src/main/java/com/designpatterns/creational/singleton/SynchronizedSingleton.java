package com.designpatterns.creational.singleton;

public class SynchronizedSingleton {
    private static SynchronizedSingleton INSTANCE;

    private SynchronizedSingleton(){}

    public static synchronized SynchronizedSingleton getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new SynchronizedSingleton();
        }
        return INSTANCE;
    }
}
