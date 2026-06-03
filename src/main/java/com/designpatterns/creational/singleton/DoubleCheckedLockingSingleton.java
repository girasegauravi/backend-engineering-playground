package com.designpatterns.creational.singleton;

public class DoubleCheckedLockingSingleton {
    private static DoubleCheckedLockingSingleton INSTANCE;

    private DoubleCheckedLockingSingleton(){}

    public static DoubleCheckedLockingSingleton getInstance() {
        if(INSTANCE == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                try {
                    Thread.sleep(2);
                } catch (Exception e) {
                }
                if(INSTANCE == null) {
                    INSTANCE = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return INSTANCE;
    }
}
