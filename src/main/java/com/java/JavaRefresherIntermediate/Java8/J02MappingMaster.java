package com.java.JavaRefresherIntermediate.Java8;
/*
==============================================================
02_Mapping.java
Java Streams Master Guide
Chapter: Mapping Operations
==============================================================

Topics
------
1. map()
2. Why map() exists
3. mapToInt()
4. mapToLong()
5. mapToDouble()
6. boxed()
7. flatMap()
8. flatMapToInt()
9. Thinking Process
10. Interview Notes

==============================================================
*/

import java.util.*;
import java.util.stream.*;

public class J02MappingMaster {

    static class Employee{
        String name;
        int age;
        double salary;
        List<String> skills;

        Employee(String name,int age,double salary,List<String> skills){
            this.name=name;
            this.age=age;
            this.salary=salary;
            this.skills=skills;
        }

        public String getName(){ return name; }
        public int getAge(){ return age; }
        public double getSalary(){ return salary; }
        public List<String> getSkills(){ return skills; }

        public String toString(){
            return name+" age="+age+" salary="+salary+" skills="+skills;
        }
    }

    public static void main(String[] args){

        List<Employee> employees = List.of(
                new Employee("John",30,70000,List.of("Java","Spring")),
                new Employee("Alex",25,55000,List.of("React","JavaScript")),
                new Employee("David",35,95000,List.of("Java","AWS","Docker"))
        );

        /*
        ==========================================================
        map()

        PURPOSE
        -------
        Transform one object into another object.

        Employee
             ↓
           String

        Employee
             ↓
           Integer

        Employee
             ↓
           Double

        map() DOES NOT modify Employee.
        It creates a NEW Stream.

        Equivalent for-loop

        List<String> names = new ArrayList<>();

        for(Employee e : employees){
            names.add(e.getName());
        }
        ==========================================================
        */

        List<String> names =
                employees.stream()
                        .map(Employee::getName)
                        .toList();

        System.out.println(names);

        /*
        ==========================================================
        mapToInt()

        WHY DOES IT EXIST?

        map()

            returns Stream<Integer>

        Every int becomes an Integer object (boxing).

        mapToInt()

            returns IntStream

        Primitive int values.
        No boxing.
        Better performance.

        Equivalent for-loop

        int sum=0;

        for(Employee e:employees){
            sum+=e.getAge();
        }
        ==========================================================
        */

        int totalAge =
                employees.stream()
                        .mapToInt(Employee::getAge)
                        .sum();

        System.out.println("Total Age = "+totalAge);

        /*
        ==========================================================
        mapToLong()

        Used when result is long.

        Returns LongStream.
        ==========================================================
        */

        long count =
                employees.stream()
                        .mapToLong(e->(long)e.getAge())
                        .count();

        System.out.println(count);

        /*
        ==========================================================
        mapToDouble()

        Returns DoubleStream.

        Useful for salary, marks, percentage.

        DoubleStream has methods like

        sum()
        average()
        max()
        min()

        ==========================================================
        */

        double salary =
                employees.stream()
                        .mapToDouble(Employee::getSalary)
                        .average()
                        .orElse(0);

        System.out.println("Average Salary = "+salary);

        /*
        ==========================================================
        boxed()

        Primitive Stream

            IntStream

                ↓

        Stream<Integer>

        Why?

        Some APIs require objects instead of primitives.
        ==========================================================
        */

        List<Integer> ages =
                employees.stream()
                        .mapToInt(Employee::getAge)
                        .boxed()
                        .toList();

        System.out.println(ages);

        /*
        ==========================================================
        flatMap()

        map()

        Employee
            ↓
        List<String>

        Result

        Stream<List<String>>

        flatMap()

        Employee
            ↓
        List<String>
            ↓
        Stream<String>

        Final Result

        Java
        Spring
        React
        JavaScript
        AWS
        Docker

        Think

        Flatten nested collections.

        Equivalent for-loop

        List<String> all = new ArrayList<>();

        for(Employee e:employees){
            all.addAll(e.getSkills());
        }

        ==========================================================
        */

        List<String> skills =
                employees.stream()
                        .flatMap(e->e.getSkills().stream())
                        .toList();

        System.out.println(skills);

        /*
        ==========================================================
        flatMapToInt()

        Example:
        List<int[]>

              ↓

        IntStream

        ==========================================================
        */

        List<int[]> arrays = List.of(
                new int[]{1,2},
                new int[]{3,4},
                new int[]{5,6}
        );

        int sum =
                arrays.stream()
                        .flatMapToInt(Arrays::stream)
                        .sum();

        System.out.println(sum);

        /*
        ==========================================================
        THINKING PROCESS

        Need names?

        Employee
            ↓
          map(getName)

        Need ages?

        Employee
            ↓
         mapToInt(getAge)

        Need salary average?

        Employee
            ↓
       mapToDouble(getSalary)
            ↓
         average()

        Need every skill?

        Employee
            ↓
        List<String>
            ↓
         flatMap()

        Need Integer List from IntStream?

        mapToInt()
             ↓
          boxed()

        ==========================================================

        INTERVIEW MEMORY

        map()
            Object -> Object

        mapToInt()
            Object -> int

        mapToLong()
            Object -> long

        mapToDouble()
            Object -> double

        flatMap()
            Many Lists -> One Stream

        boxed()
            Primitive -> Wrapper

        ==========================================================
        */
    }
}
