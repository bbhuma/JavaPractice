package com.java.JavaRefresherIntermediate.Java8;

import java.util.*;

//------------------------------------------------------
//4. Comparator.comparingInt()
//------------------------------------------------------

/*
* Comparator.comparingInt(...)
*
* Purpose:
* --------
* Creates a Comparator based on an int field of an object.
*
* It DOES NOT compare objects directly.
* It RETURNS a Comparator<Employee>.
*
* Think of it as:
*
*      "Create a Comparator using this int property."
*
* Here,
*
*      e -> e.salary
*
* means:
*
*      Take an Employee object
*              ↓
*      Extract its salary
*              ↓
*      Use salary for comparison
*
* Example:
*
*      John   -> 60000
*      David  -> 40000
*
* Java internally compares:
*
*      Integer.compare(60000, 40000)
*
* So this line:
*
*      Comparator.comparingInt(e -> e.salary)
*
* is equivalent to:
*
*      (a, b) -> Integer.compare(a.salary, b.salary)
*
* which is also equivalent to:
*
*      new Comparator<Employee>() {
*
*          @Override
*          public int compare(Employee a, Employee b) {
*              return Integer.compare(a.salary, b.salary);
*          }
*      };
*
* Read it in English:
*
*      "Create a Comparator by comparing the salary field."


Arrays.sort(employees,
     Comparator.comparingInt(e -> e.salary));
Arrays.sort(employees,
     Comparator.comparing(e -> e.name));

System.out.println("\nComparator.comparingInt()");
print(employees);
*/
public class ArraysComparatorVsComparable {

    public static void main(String[] args) {

        Employee[] employees = {
                new Employee("John", 60000, 30),
                new Employee("David", 40000, 28),
                new Employee("Mike", 90000, 35),
                new Employee("Alex", 50000, 25)
        };

        //------------------------------------------------------
        // 1. Comparable
        //------------------------------------------------------

        Arrays.sort(employees);

        System.out.println("Employee Object knows to compare itself to others based only on one parameter ie. Salary"+ "\nComparable (Salary)");
        print(employees);


        //------------------------------------------------------
        // 2. Comparator - Anonymous Class
        //------------------------------------------------------

        Arrays.sort(employees, new Comparator<Employee>() {

            @Override
            public int compare(Employee a, Employee b) {

                return a.name.compareTo(b.name);

            }

        });

        System.out.println("\nComparator (Name)");
        print(employees);


        //------------------------------------------------------
        // 3. Comparator - Lambda
        //------------------------------------------------------

        Arrays.sort(employees,
                (a, b) -> Integer.compare(a.age, b.age));

        System.out.println("\nComparator Lambda (Age)");
        print(employees);


        //------------------------------------------------------
        // 4. Comparator.comparingInt()
        //------------------------------------------------------

        Arrays.sort(employees,
                Comparator.comparingInt(e -> e.salary));

        System.out.println("\nComparator.comparingInt()");
        print(employees);


        //------------------------------------------------------
        // 5. Reverse Order
        //------------------------------------------------------

        Arrays.sort(employees,
                Comparator.comparingInt((Employee e) -> e.salary)
                        .reversed());

        System.out.println("\nReverse Salary");
        print(employees);


        //------------------------------------------------------
        // 6. Integer.compare()
        //------------------------------------------------------

        System.out.println("\nInteger.compare()");

        System.out.println(Integer.compare(10,20));
        System.out.println(Integer.compare(20,10));
        System.out.println(Integer.compare(20,20));


        //------------------------------------------------------
        // 7. String.compareTo()
        //------------------------------------------------------

        System.out.println("\nString.compareTo()");

        System.out.println("Apple".compareTo("Banana"));
        System.out.println("Banana".compareTo("Apple"));
        System.out.println("Apple".compareTo("Apple"));
    }


    static void print(Employee[] employees){

        for(Employee e : employees){

            System.out.println(e);

        }

    }

}



class Employee implements Comparable<Employee>{

    String name;
    int salary;
    int age;

    Employee(String name,int salary,int age){

        this.name=name;
        this.salary=salary;
        this.age=age;

    }

    //------------------------------------------------------
    // Comparable
    //------------------------------------------------------

    @Override
    public int compareTo(Employee other){

        return Integer.compare(this.salary,other.salary);

    }


    @Override
    public String toString(){

        return name+" Salary="+salary+" Age="+age;

    }

}