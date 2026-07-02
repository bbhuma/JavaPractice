
package com.java.JavaRefresherIntermediate.Java8;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/*
===============================================================================
J21_MethodReferenceMaster_V2.java
INTERVIEW EDITION

Method Reference = Shorter form of a lambda.

Lambda

    x -> x.length()

Method Reference

    String::length

Interview Rating : ★★★★★

There are FOUR types of method references:

1. Static Method Reference
2. Instance Method Reference of a Particular Object
3. Instance Method Reference of an Arbitrary Object of a Type
4. Constructor Reference

===============================================================================
*/

public class J21_MethodReferenceMaster_V2 {

    // ---------- Static Method ----------
    static class MathUtil {
        static int square(int x){
            return x * x;
        }
    }

    // ---------- Instance Method ----------
    static class Printer{
        void print(String s){
            System.out.println("Printer : " + s);
        }
    }

    // ---------- Constructor ----------
    static class Employee{
        String name;

        Employee(){
            this.name = "Default";
        }

        Employee(String name){
            this.name = name;
        }

        public String toString(){
            return name;
        }
    }

    public static void main(String[] args){

        /*
        ===========================================================================
        1. STATIC METHOD REFERENCE

        Lambda

            x -> Integer.parseInt(x)

        Method Reference

            Integer::parseInt

        Think

            Class::staticMethod
        ===========================================================================
        */

        Function<String,Integer> parse = Integer::parseInt;

        System.out.println(parse.apply("100"));

        /*
        Integer::valueOf

        String

            ↓

        Integer Object
        */

        Function<String,Integer> valueOf =
                Integer::valueOf;

        System.out.println(valueOf.apply("500"));

        /*
        Integer::compare

        Signature

        int compare(int x,int y)

        Used heavily inside

        Arrays.sort()

        PriorityQueue

        Comparator

        Lambda

            (a,b) -> Integer.compare(a,b)
        */

        Comparator<Integer> cmp = Integer::compare;

        System.out.println(cmp.compare(10,20));

        /*
        Double::compare
        Long::compare
        String::compareToIgnoreCase

        are also common.
        */

        Comparator<Double> doubleCmp =
                Double::compare;

        Comparator<Long> longCmp =
                Long::compare;

        Comparator<String> ignoreCase =
                String::compareToIgnoreCase;

        System.out.println(ignoreCase.compare("java","JAVA"));

        /*
        ===========================================================================
        2. INSTANCE METHOD OF A PARTICULAR OBJECT

        object::instanceMethod

        Lambda

            s -> printer.print(s)

        Method Reference

            printer::print
        ===========================================================================
        */

        Printer printer = new Printer();

        Consumer<String> consumer =
                printer::print;

        consumer.accept("Hello");

        /*
        ===========================================================================
        3. INSTANCE METHOD OF AN ARBITRARY OBJECT

        Class::instanceMethod

        Java supplies the object.

        Lambda

            s -> s.length()

        Method Reference

            String::length
        ===========================================================================
        */

        Function<String,Integer> length =
                String::length;

        System.out.println(length.apply("Interview"));

        /*
        Another Example

        String::toUpperCase

        Lambda

            s -> s.toUpperCase()
        */

        Function<String,String> upper =
                String::toUpperCase;

        System.out.println(upper.apply("java"));

        /*
        String::trim
        String::isBlank
        String::isEmpty

        are frequently used.
        */

        Predicate<String> blank =
                String::isBlank;

        System.out.println(blank.test("   "));

        /*
        ===========================================================================
        4. CONSTRUCTOR REFERENCE

        Class::new

        Lambda

            () -> new Employee()

        Method Reference

            Employee::new
        ===========================================================================
        */

        Supplier<Employee> empSupplier =
                Employee::new;

        System.out.println(empSupplier.get());

        /*
        Constructor with arguments

        Lambda

            s -> new Employee(s)
        */

        Function<String,Employee> creator =
                Employee::new;

        System.out.println(creator.apply("John"));

        /*
        ===========================================================================
        STREAM EXAMPLES
        ===========================================================================
        */

        List<String> names =
                Arrays.asList("John","Alex","David");

        // String::length
        List<Integer> lengths =
                names.stream()
                        .map(String::length)
                        .toList();

        // String::toUpperCase
        List<String> upperNames =
                names.stream()
                        .map(String::toUpperCase)
                        .toList();

        // System.out::println
        upperNames.forEach(System.out::println);

        /*
        ===========================================================================
        COMPARATOR + METHOD REFERENCES
        ===========================================================================
        */

        List<Employee> employees =
                Arrays.asList(
                        new Employee("John"),
                        new Employee("Alex"),
                        new Employee("David"));

        employees.sort(
                Comparator.comparing(e -> e.name)
        );

        /*
        Better

        Comparator.comparing(Employee::toString)

        More common examples

        Comparator.comparing(Employee::getName)
        Comparator.comparingInt(Employee::getAge)
        Comparator.comparingDouble(Employee::getSalary)
        */

        /*
        ===========================================================================
        MOST COMMON METHOD REFERENCES IN INTERVIEWS

        Integer::parseInt
        Integer::valueOf
        Integer::compare

        Long::compare
        Double::compare

        String::length
        String::trim
        String::toUpperCase
        String::toLowerCase
        String::isBlank
        String::compareToIgnoreCase

        Arrays::stream

        System.out::println

        Math::abs
        Math::sqrt
        Math::max
        Math::min

        Objects::nonNull
        Objects::isNull

        Employee::new
        Employee::getName
        Employee::getSalary

        Comparator.comparing(Employee::getName)
        Comparator.comparingInt(Employee::getAge)
        Comparator.comparingDouble(Employee::getSalary)
        ===========================================================================
        */

        /*
        MEMORY TRICK

        Class::staticMethod

            Integer::compare

        object::instanceMethod

            printer::print

        Class::instanceMethod

            String::length

        Class::new

            Employee::new
        */
    }
}
