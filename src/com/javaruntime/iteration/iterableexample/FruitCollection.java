package com.javaruntime.iteration.iterableexample;

/*
PROBLEM:
Create a custom class that can be used in a for-each loop.

Normally we use:
    ArrayList
    HashSet
    etc.

because they are iterable.

But how can OUR OWN class become iterable?

========================================================
ITERABLE IN JAVA
========================================================

To make a class iterable:
    1. Implement Iterable<T>
    2. Override iterator()
    3. Return an Iterator object

This allows:
    for-each loop support

========================================================
FLOW
========================================================

for (String item : myCollection)

internally becomes:

Iterator<String> it = myCollection.iterator();

while(it.hasNext()) {
    String item = it.next();
}

========================================================
KEY INTERFACES
========================================================

Iterable<T>
    method:
        Iterator<T> iterator()

Iterator<T>
    methods:
        hasNext()
        next()

========================================================
OUTPUT
========================================================

Apple
Banana
Mango
Orange
*/

import java.util.Iterator;
import java.util.NoSuchElementException;

class FruitCollection implements Iterable<String> {

    private String[] fruits;
    private int size;

    public FruitCollection(String[] fruits) {
        this.fruits = fruits;
        this.size = fruits.length;
    }

    /*
        Returning custom iterator
    */
    @Override
    public Iterator<String> iterator() {

        return new Iterator<String>() {

            int index = 0;

            /*
                Checks if more elements exist
            */
            @Override
            public boolean hasNext() {
                return index < size;
            }

            /*
                Returns next element
            */
            @Override
            public String next() {

                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                return fruits[index++];
            }
        };
    }
}

class Main {

    public static void main(String[] args) {

        String[] arr = {
                "Apple",
                "Banana",
                "Mango",
                "Orange"
        };

        FruitCollection fruits = new FruitCollection(arr);

        /*
            Because FruitCollection implements Iterable,
            it can now be used in for-each loop
        */
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}