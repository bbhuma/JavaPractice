
package com.java.JavaRefresherIntermediate.Java8;

import java.util.Comparator;
import java.util.function.*;

/*
===============================================================================
J23_MethodReferenceResolution.java

Goal
----
How does Java know which functional interface a method reference matches?

Rule:
Count INPUT parameters
Count RETURN value

Then match the Single Abstract Method (SAM).

Interview Rating : ★★★★★
===============================================================================
*/
public class J23_MethodReferenceResolution {

    static class Employee{
        String name;
        Employee(String n){name=n;}
        String getName(){ return name; }
    }

    public static void main(String[] args){

        /*
        Integer::parseInt

        Signature

            static int parseInt(String)

        Inputs : 1
        Output : int

        Matches

            Function<String,Integer>
        */
        Function<String,Integer> parse = Integer::parseInt;
        System.out.println(parse.apply("123"));

        /*
        System.out::println

        Signature

            void println(String)

        Inputs : 1
        Output : void

        Matches

            Consumer<String>
        */
        Consumer<String> printer = System.out::println;
        printer.accept("Hello");

        /*
        Employee::new

        Signature

            Employee(String)

        Inputs : 1
        Output : Employee

        Matches

            Function<String,Employee>
        */
        Function<String,Employee> creator = Employee::new;
        System.out.println(creator.apply("John").getName());

        /*
        Integer::compare

        Signature

            static int compare(int,int)

        Inputs : 2
        Output : int

        Matches

            Comparator<Integer>

        because Comparator.compare(T,T)
        also has 2 inputs and returns int.
        */
        Comparator<Integer> cmp = Integer::compare;
        System.out.println(cmp.compare(5,9));

        /*
        String::length

        Signature

            int length()

        Looks like no input?

        Java supplies the object.

        Lambda

            s -> s.length()

        Therefore matches

            Function<String,Integer>
        */

        Function<String,Integer> len = String::length;
        System.out.println(len.apply("ABCDE"));

        /*
        Memory Rule

        0 input -> Supplier
        1 input + return -> Function
        1 input + void -> Consumer
        1 input + boolean -> Predicate
        2 input + return -> BiFunction
        2 same input + same return -> BinaryOperator
        2 input + int -> Comparator.compare()
        */
    }
}
