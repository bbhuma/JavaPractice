
package com.java.JavaRefresherIntermediate.Java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

/*
===============================================================================
J02_MapMaster.java

INTERVIEW HANDBOOK

Focus:
- map()
- mapToInt()
- mapToLong()
- mapToDouble()
- boxed()

Think:
Object --------> Another Object  => map()
Object --------> int             => mapToInt()
Object --------> long            => mapToLong()
Object --------> double          => mapToDouble()

Interview Rating : ★★★★★
===============================================================================
*/

public class J02_MapMaster_InterviewStyle {

    static class Employee{
        String name;
        int age;
        double salary;

        Employee(String n,int a,double s){
            name=n; age=a; salary=s;
        }

        public String getName(){ return name; }
        public int getAge(){ return age; }
        public double getSalary(){ return salary; }
    }

    public static void main(String[] args){

        List<Employee> employees = List.of(
            new Employee("John",30,70000),
            new Employee("Alex",24,55000),
            new Employee("David",35,92000)
        );

        /*
        ===========================================================================
        WHY map()?

        Collections store Employee objects.

        Often interviews ask:

            Employee
                 ↓
              Salary

            Employee
                 ↓
               Name

            Employee
                 ↓
               Age

        map() transforms EACH element.

        Signature

        <R> Stream<R> map(Function<? super T,? extends R> mapper)

        T = current stream type
        R = new stream type

        Stream<Employee>

              map(Employee::getName)

        becomes

        Stream<String>

        ===========================================================================
        */

        List<String> names = employees.stream()
                .map(Employee::getName)
                .toList();

        System.out.println(names);

        /*
        ===========================================================================
        INTERNAL WORKING (Simplified)

        Employee

          ↓ mapper.apply()

        String

          ↓

        New Stream<String>

        NOTE

        map() DOES NOT execute immediately.

        Java stores the pipeline.

        Execution starts only after a TERMINAL OPERATION.
        ===========================================================================
        */

        /*
        ===========================================================================
        mapToInt()

        Why?

        map(Employee::getAge)

        returns Stream<Integer>

        Integer objects require boxing.

        mapToInt(Employee::getAge)

        returns IntStream

        Primitive stream
        Less memory
        Faster aggregation

        Common interview follow-up:
        Why can IntStream call sum() directly?
        Because it stores primitive ints.
        ===========================================================================
        */

        int totalAge = employees.stream()
                .mapToInt(Employee::getAge)
                .sum();

        System.out.println(totalAge);

        /*
        mapToLong()

        Used when target value is long.

        Returns LongStream.
        */

        long count = employees.stream()
                .mapToLong(e -> (long)e.getAge())
                .count();

        System.out.println(count);

        /*
        mapToDouble()

        Best for salary, marks, percentages.
        */

        double avgSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);

        System.out.println(avgSalary);

        /*
        boxed()

        IntStream

            ↓

        Stream<Integer>

        Use when another API expects wrapper objects.
        */

        List<Integer> ages = employees.stream()
                .mapToInt(Employee::getAge)
                .boxed()
                .toList();

        System.out.println(ages);

        /*
        IMPLEMENT YOUR OWN MAP

        static <T,R> List<R> myMap(
            List<T> list,
            Function<T,R> mapper){

            List<R> out = new ArrayList<>();

            for(T t:list){
                out.add(mapper.apply(t));
            }

            return out;
        }

        This is conceptually what map() does.

        MEMORY

        map()      => transform object
        mapToInt() => primitive int
        boxed()    => primitive -> wrapper
        */
    }
}
