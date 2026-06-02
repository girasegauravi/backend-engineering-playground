package com.javaruntime.hashcodeandequals;

/*
PROBLEM:
Understand why equals() and hashCode() are important,
especially in HashSet and HashMap.

========================================================
DEFAULT BEHAVIOR
========================================================

Every Java class inherits:
    equals()
    hashCode()

from Object class.

Default implementation compares:
    MEMORY ADDRESS (reference)

Meaning:
    Two objects with same data are NOT equal
    unless we override equals()

========================================================
WHY hashCode() MATTERS
========================================================

Hash-based collections:
    HashSet
    HashMap
    Hashtable

use:
    1. hashCode() -> find bucket
    2. equals()   -> compare objects inside bucket

========================================================
CONTRACT
========================================================

If two objects are equal according to equals(),
their hashCode() MUST be same.

if:
    a.equals(b) == true

then:
    a.hashCode() == b.hashCode()

========================================================
IMPORTANT INTERVIEW POINT
========================================================

Override BOTH:
    equals()
    hashCode()

Overriding only equals() causes problems
in HashSet/HashMap.

========================================================
EXAMPLE
========================================================

Two Employee objects:
    same id
    same name

should be treated as duplicate.

========================================================
EXPECTED OUTPUT
========================================================

e1.equals(e2) = true

HashSet size = 1

Because duplicate object is ignored.
*/

import java.util.HashSet;
import java.util.Objects;

class Employee {

    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /*
        Logical equality
        Compare object DATA
    */
    @Override
    public boolean equals(Object obj) {

        /*
            Same memory reference
        */
        if (this == obj) {
            return true;
        }

        /*
            Null check
        */
        if (obj == null) {
            return false;
        }

        /*
            Class type check
        */
        if (getClass() != obj.getClass()) {
            return false;
        }

        Employee other = (Employee) obj;

        return this.id == other.id &&
                Objects.equals(this.name, other.name);
    }

    /*
        Same objects must return same hashCode
    */
    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Employee{id=" + id +
                ", name='" + name + '\'' + '}';
    }
}

class Main {

    public static void main(String[] args) {

        Employee e1 = new Employee(101, "Rahul");

        Employee e2 = new Employee(101, new String("Rahul"));

        /*
            equals() compares DATA
        */
        System.out.println(
                "e1.equals(e2) = " + e1.equals(e2)
        );

        /*
            HashSet uses:
                hashCode()
                equals()

            Duplicate object won't be inserted
        */
        HashSet<Employee> set = new HashSet<>();

        set.add(e1);
        set.add(e2);

        System.out.println(
                "HashSet size = " + set.size()
        );

        System.out.println(set);
    }
}
