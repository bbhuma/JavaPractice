
package com.java.JavaRefresherIntermediate.Java8;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/*
===============================================================================
J22_CommonMethodReferences.java
Interview Cheat Sheet

Purpose:
Most commonly used method references grouped by Java class.
For each example:
- Equivalent lambda
- Functional interface
- Typical interview usage
===============================================================================
*/
public class J22_CommonMethodReferences {

    static class Employee{
        String name; int age; double salary;
        Employee(){}
        Employee(String n){name=n;}
        Employee(String n,int a,double s){name=n;age=a;salary=s;}
        String getName(){return name;}
        int getAge(){return age;}
        double getSalary(){return salary;}
        public String toString(){return name;}
    }

    public static void main(String[] args){

        /* ================= Integer =================
         Integer::parseInt
         Lambda : s -> Integer.parseInt(s)
         Function<String,Integer>
        */
        Function<String,Integer> parse = Integer::parseInt;
        System.out.println(parse.apply("123"));

        /* Integer::valueOf
           Creates Integer object.
        */
        Function<String,Integer> valueOf = Integer::valueOf;
        System.out.println(valueOf.apply("456"));

        /* Integer::compare
           Lambda : (a,b)->Integer.compare(a,b)
           Comparator<Integer>
           Used in Arrays.sort(), PriorityQueue, Comparator.
        */
        Comparator<Integer> intCmp = Integer::compare;
        System.out.println(intCmp.compare(5,8));

        BinaryOperator<Integer> intSum = Integer::sum;
        BinaryOperator<Integer> intMax = Integer::max;
        BinaryOperator<Integer> intMin = Integer::min;
        System.out.println(intSum.apply(10,20));
        System.out.println(intMax.apply(10,20));
        System.out.println(intMin.apply(10,20));

        /* ================= Long / Double ================= */
        Comparator<Long> longCmp = Long::compare;
        Comparator<Double> doubleCmp = Double::compare;
        System.out.println(longCmp.compare(5L,2L));
        System.out.println(doubleCmp.compare(2.5,2.5));

        /* ================= String ================= */
        Function<String,Integer> len = String::length;
        Function<String,String> upper = String::toUpperCase;
        Function<String,String> lower = String::toLowerCase;
        Function<String,String> trim = String::trim;
        Predicate<String> blank = String::isBlank;
        Predicate<String> empty = String::isEmpty;
        Comparator<String> ignoreCase = String::compareToIgnoreCase;

        System.out.println(len.apply("Java"));
        System.out.println(upper.apply("java"));
        System.out.println(trim.apply("  hi "));
        System.out.println(blank.test("   "));
        System.out.println(ignoreCase.compare("abc","ABC"));

        /* ================= Arrays ================= */
        int[] arr={1,2,3};
        System.out.println(Arrays.stream(arr).sum()); // Arrays::stream
        System.out.println(Arrays.toString(arr));      // Arrays::toString

        /* ================= Math ================= */
        Function<Integer,Integer> abs = Math::abs;
        Function<Double,Double> sqrt = Math::sqrt;
        BinaryOperator<Integer> max = Math::max;
        BinaryOperator<Integer> min = Math::min;
        System.out.println(abs.apply(-9));
        System.out.println(sqrt.apply(25.0));
        System.out.println(max.apply(5,9));
        System.out.println(min.apply(5,9));

        /* ================= Objects =================
           Useful in Streams to remove nulls.
        */
        List<String> names = Arrays.asList("John",null,"Alex",null,"David");
        System.out.println(
            names.stream()
                 .filter(Objects::nonNull)
                 .toList()
        );

        /* ================= System.out ================= */
        names.stream()
             .filter(Objects::nonNull)
             .forEach(System.out::println);

        /* ================= Constructors ================= */
        Supplier<Employee> emp1 = Employee::new;
        Function<String,Employee> emp2 = Employee::new;
        Supplier<ArrayList<String>> list = ArrayList::new;
        Supplier<HashMap<Integer,String>> map = HashMap::new;
        Supplier<HashSet<Integer>> set = HashSet::new;

        System.out.println(emp1.get());
        System.out.println(emp2.apply("John"));

        /* ================= Comparator ================= */
        List<Employee> employees = Arrays.asList(
            new Employee("John",30,70000),
            new Employee("Alex",25,50000),
            new Employee("David",35,90000));

        employees.sort(Comparator.comparing(Employee::getName));
        employees.sort(Comparator.comparingInt(Employee::getAge));
        employees.sort(Comparator.comparingDouble(Employee::getSalary));

        /*
        ================= INTERVIEW TOP 20 =================

        Integer::compare
        Integer::parseInt
        Integer::valueOf
        Integer::sum

        String::length
        String::trim
        String::toUpperCase
        String::toLowerCase
        String::isBlank
        String::compareToIgnoreCase

        Arrays::stream

        Objects::nonNull
        Objects::isNull

        Math::max
        Math::min
        Math::abs
        Math::sqrt

        System.out::println

        Employee::new
        Employee::getName
        Employee::getAge
        Employee::getSalary

        Comparator.comparing(Employee::getName)
        Comparator.comparingInt(Employee::getAge)
        Comparator.comparingDouble(Employee::getSalary)

        MEMORY

        Class::staticMethod
        object::instanceMethod
        Class::instanceMethod
        Class::new
        */
    }
}
