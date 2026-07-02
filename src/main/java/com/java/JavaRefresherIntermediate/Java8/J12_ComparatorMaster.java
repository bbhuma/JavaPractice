
package com.java.JavaRefresherIntermediate.Java8;

import java.util.*;

/*
===============================================================================
J12_ComparatorMaster.java
(Java Interview Handbook)

This chapter explains the COMPLETE Comparator story.

Interview Rating : ★★★★★

Topics
------
1. Why Comparable?
2. Why Comparator?
3. compare()
4. compareTo()
5. Anonymous Comparator
6. Lambda Comparator
7. Integer.compare()
8. Comparator.comparing()
9. comparingInt()
10. reversed()
11. thenComparing()
12. DSA Examples
===============================================================================
*/

public class J12_ComparatorMaster {

    static class Employee implements Comparable<Employee>{

        String name;
        int age;
        double salary;

        Employee(String name,int age,double salary){
            this.name=name;
            this.age=age;
            this.salary=salary;
        }

        /*
        ===========================================================================
        Comparable

        Object compares ITSELF.

        Default ordering.

        Arrays.sort(employeeArray)

        automatically calls compareTo().
        ===========================================================================
        */
        @Override
        public int compareTo(Employee other){
            return Integer.compare(this.age, other.age);
        }

        public String toString(){
            return name+" age="+age+" salary="+salary;
        }
    }

    public static void main(String[] args){

        Employee[] employees={
            new Employee("John",30,70000),
            new Employee("Alex",25,50000),
            new Employee("David",35,90000),
            new Employee("Bob",30,65000)
        };

        /*
        ===========================================================================
        WHY COMPARATOR?

        Comparable gives ONE default ordering.

        But interviews ask:

        Sort by age
        Sort by salary
        Sort by name

        We need MULTIPLE strategies.

        Comparator solves this.
        ===========================================================================
        */

        Arrays.sort(employees);
        System.out.println("Comparable (Age)");
        print(employees);

        /*
        ===========================================================================
        Anonymous Comparator

        Before Java 8.
        ===========================================================================
        */

        Arrays.sort(employees,new Comparator<Employee>(){
            @Override
            public int compare(Employee a,Employee b){
                return a.name.compareTo(b.name);
            }
        });

        System.out.println("\nComparator (Name)");
        print(employees);

        /*
        ===========================================================================
        Lambda Comparator

        Java 8 shortcut.

        (a,b) -> Integer.compare(a.age,b.age)

        is equivalent to the anonymous class above.
        ===========================================================================
        */

        Arrays.sort(employees,
                (a,b)->Double.compare(a.salary,b.salary));

        System.out.println("\nLambda (Salary)");
        print(employees);

        /*
        ===========================================================================
        Integer.compare()

        Why?

        Avoid integer overflow caused by

            return a-b;

        Integer.compare()

        safely returns

        negative
        zero
        positive
        ===========================================================================
        */

        System.out.println(Integer.compare(10,20));
        System.out.println(Integer.compare(20,10));
        System.out.println(Integer.compare(20,20));

        /*
        ===========================================================================
        Comparator.comparing()

        Creates Comparator using object property.
        */

        Arrays.sort(employees,
                Comparator.comparing(e->e.name));

        /*
        comparingInt()

        Same idea but optimized for int.

        Equivalent

        (a,b)->Integer.compare(a.age,b.age)
        */

        Arrays.sort(employees,
                Comparator.comparingInt(e->e.age));

        /*
        reversed()

        Reverse existing Comparator.
        */

        Arrays.sort(employees,
                Comparator.comparingDouble((Employee e)->e.salary)
                        .reversed());

        /*
        thenComparing()

        Primary sort : age

        Secondary sort : name
        */

        Arrays.sort(employees,
                Comparator.comparingInt((Employee e)->e.age)
                        .thenComparing(e->e.name));

        System.out.println("\nAge then Name");
        print(employees);

        /*
        ===========================================================================
        DSA Example

        K Closest Points

        Arrays.sort(points,

            (a,b)->Integer.compare(

                a[0]*a[0]+a[1]*a[1],

                b[0]*b[0]+b[1]*b[1]

            ));

        THINKING

        Element?

            Point

        Property?

            Distance

        Datatype?

            int

        Compare?

            Integer.compare()

        ===========================================================================
        */

        /*
        MEMORY

        Comparable

            compareTo()

            ONE default order

        Comparator

            compare()

            MANY custom orders

        Function

            transform

        Predicate

            decide

        Consumer

            use

        Supplier

            create
        */
    }

    static void print(Employee[] arr){
        for(Employee e:arr){
            System.out.println(e);
        }
    }
}
