
package com.java.JavaRefresherIntermediate.Java8;

import java.util.*;
import java.util.stream.*;

/*
===============================================================================
J04_FlatMapMaster.java

Topics
------
flatMap()
flatMapToInt()
Nested Collections
Interview Thinking

Interview Rating : ★★★★★
===============================================================================
*/
public class J04_FlatMapMaster {

    static class Employee{
        String name;
        List<String> skills;
        Employee(String n,List<String> s){
            name=n; skills=s;
        }
        List<String> getSkills(){ return skills; }
        public String toString(){ return name+skills; }
    }

    public static void main(String[] args){

        List<Employee> employees = List.of(
            new Employee("John",List.of("Java","Spring")),
            new Employee("Alex",List.of("React","TypeScript")),
            new Employee("David",List.of("Java","AWS","Docker"))
        );

        /*
        ===========================================================================
        WHY flatMap() ?

        map()

            Employee
                |
                V
            List<String>

        Result

        Stream<List<String>>

        BUT...

        Interview asks:

            "Give me ALL skills."

        We do NOT want

            [[Java,Spring],[React],[AWS]]

        We want

            Java
            Spring
            React
            AWS

        flatMap()

        flattens

        Stream<List<T>>

                 ↓

           Stream<T>

        ===========================================================================
        */

        List<String> allSkills =
                employees.stream()
                        .flatMap(e -> e.getSkills().stream())
                        .toList();

        System.out.println(allSkills);

        /*
        Equivalent Loop

        List<String> out = new ArrayList<>();

        for(Employee e:employees){
            out.addAll(e.getSkills());
        }

        Complexity

        O(total elements)

        Memory Trick

        map()

            one -> one

        flatMap()

            one -> many -> flatten
        */

        List<int[]> arrays = List.of(
            new int[]{1,2},
            new int[]{3,4},
            new int[]{5,6}
        );

        /*
        flatMapToInt()

        Stream<int[]>

             ↓

        IntStream

        Useful for primitive aggregation.
        */

        int sum = arrays.stream()
                .flatMapToInt(Arrays::stream)
                .sum();

        System.out.println(sum);

        /*
        Interview Questions

        1. map vs flatMap
        2. Why nested collections need flatMap?
        3. flatMap with Optional?
        4. Why flatMapToInt exists?
        */
    }
}
