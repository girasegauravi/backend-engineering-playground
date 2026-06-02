package com.javaruntime.collections.comparableexample;
/*
PROBLEM:
You have a list of employees.
You want to sort them in different ways:

1. Sort by ID (natural/default sorting)
2. Sort by Name
3. Sort by Salary descending

Java provides two mechanisms for sorting objects:

========================================================
1. Comparable
========================================================
- Present in java.lang package
- Class itself defines its natural/default sorting
- Uses:
        compareTo()

Method:
        int compareTo(T obj)

Rules:
    return negative -> current object comes before
    return positive -> current object comes after
    return 0        -> both are equal

Example:
    Employee compares by ID

========================================================
2. Comparator
========================================================
- Present in java.util package
- External/custom sorting logic
- Multiple sorting strategies possible
- Uses:
        compare(obj1, obj2)

Method:
        int compare(T o1, T o2)

Example:
    Sort by name
    Sort by salary

========================================================
KEY DIFFERENCE
========================================================

Comparable:
    - One default sorting
    - Logic inside class

Comparator:
    - Multiple custom sortings
    - Logic outside class

========================================================
TIME COMPLEXITY
========================================================
Collections.sort():
    O(n log n)

========================================================
OUTPUT EXPECTED
========================================================

Original List
Sorted by ID
Sorted by Name
Sorted by Salary Descending
*/

import java.util.*;

class Employee implements Comparable<Employee> {

    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee other) {
        return this.id - other.id;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary + '}';
    }
}

/*
    Comparator for Name sorting
*/
class NameComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {

        /*
            String already implements Comparable
        */

        return e1.name.compareTo(e2.name);
    }
}

/*
    Comparator for Salary Descending sorting
*/
class SalaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {

        /*
            Descending order

            Higher salary first
        */

        return Double.compare(e2.salary, e1.salary);
    }
}

class Main {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(103, "Rahul", 70000));
        employees.add(new Employee(101, "Amit", 9000));
        employees.add(new Employee(104, "Sneha", 65000));
        employees.add(new Employee(102, "Priya", 85000));

        /*
            Original Order
        */
        System.out.println("Original List");
        System.out.println(employees);

        Collections.sort(employees);

        System.out.println("\nSorted By ID (Comparable)");
        System.out.println(employees);

        Collections.sort(employees, new NameComparator());

        System.out.println("\nSorted By Name (Comparator)");
        System.out.println(employees);

        Collections.sort(employees, new SalaryComparator());

        System.out.println("\nSorted By Salary Descending (Comparator)");
        System.out.println(employees);
    }
}