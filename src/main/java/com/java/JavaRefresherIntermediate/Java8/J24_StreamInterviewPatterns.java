
package com.java.JavaRefresherIntermediate.Java8;

import java.util.*;
import java.util.stream.*;

/*
===============================================================================
J24_StreamInterviewPatterns.java

Top Stream patterns repeatedly asked in interviews.
===============================================================================
*/
public class J24_StreamInterviewPatterns {

    static class Employee{
        String name,dept;
        int age;
        double salary;
        Employee(String n,String d,int a,double s){
            name=n;dept=d;age=a;salary=s;
        }
        String getName(){return name;}
        String getDept(){return dept;}
        int getAge(){return age;}
        double getSalary(){return salary;}
    }

    public static void main(String[] args){

        List<Employee> list = List.of(
            new Employee("John","IT",30,70000),
            new Employee("Alex","HR",24,45000),
            new Employee("David","IT",35,95000),
            new Employee("Mary","HR",28,55000)
        );

        // 1. Names
        System.out.println(list.stream().map(Employee::getName).toList());

        // 2. Average salary
        System.out.println(list.stream().mapToDouble(Employee::getSalary).average());

        // 3. Highest salary
        System.out.println(list.stream().max(Comparator.comparingDouble(Employee::getSalary)));

        // 4. Group by department
        System.out.println(list.stream().collect(Collectors.groupingBy(Employee::getDept)));

        // 5. Count by department
        System.out.println(list.stream().collect(
            Collectors.groupingBy(Employee::getDept,Collectors.counting())));

        // 6. Employee names by department
        System.out.println(list.stream().collect(
            Collectors.groupingBy(Employee::getDept,
                Collectors.mapping(Employee::getName,Collectors.toList()))));

        // 7. Sort by salary desc
        System.out.println(list.stream()
            .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
            .map(Employee::getName)
            .toList());

        // 8. Any employee > 90000?
        System.out.println(list.stream().anyMatch(e->e.getSalary()>90000));

        // 9. Partition
        System.out.println(list.stream().collect(
            Collectors.partitioningBy(e->e.getAge()>30)));

        // 10. Join names
        System.out.println(list.stream()
            .map(Employee::getName)
            .collect(Collectors.joining(", ")));
    }
}
